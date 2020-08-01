package util;

import common.KeyNotFoundException;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.sql.*;
import java.util.*;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/27 19:54
 */
public class DbUtil {

    private static Properties properties;
    private static final ThreadLocal<Connection> CONNECTION_THREAD_LOCAL = new ThreadLocal<>();

    //共享
    static {
        //类加载器，启动类记载器，扩展，应用，其他
        //静态代码块里面适合做一些初始化的动作，资源先到位，load到内存的时候执行
        properties = new Properties();
        try {
            properties.load(new FileInputStream("resources/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws Exception {
        Connection conn = CONNECTION_THREAD_LOCAL.get();

        if (conn == null) {
            String url = getPropertiesValue("url");
            String user = getPropertiesValue("user");
            String password = getPropertiesValue("password");
            conn = DriverManager.getConnection(url, user, password);

            CONNECTION_THREAD_LOCAL.set(conn);
        }

        return conn;
    }

    /**
     * 关闭DB连接池，线程池
     */
    public static void closeConn() {
        Connection conn = CONNECTION_THREAD_LOCAL.get();
        if (conn != null) {
            try {
                conn.close();
                CONNECTION_THREAD_LOCAL.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static int executeUpdate(String sql, Object... paras) throws Exception {
        //获取连接
        Connection conn = getConn();
        int i = 0;
        //PreparedStatement执行效率更高，预先编译好
        //执行SQL语句
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        if (paras != null && paras.length > 0) {
            for (int j = 0; j < paras.length; j++) {
                preparedStatement.setObject(j + 1, paras[j]);
            }
        }
        i = preparedStatement.executeUpdate();
        return i;
    }

    /**
     * 获取新插入记录的主键
     *
     * @param sql
     * @param paras
     * @return
     * @throws KeyNotFoundException
     * @throws SQLException
     */
    public static int executeGetKey(String sql, Object... paras) throws Exception {
        //获取连接
        Connection conn = getConn();
        int i = 0;
        //PreparedStatement执行效率更高，预先编译好
        //执行SQL语句
        PreparedStatement preparedStatement = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        if (paras != null && paras.length > 0) {
            for (int j = 0; j < paras.length; j++) {
                preparedStatement.setObject(j + 1, paras[j]);
            }
        }
        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            i = generatedKeys.getInt(1);
        }
        return i;
    }

    public static List<Map<String, Object>> executeQuery(String sql, Object... paras) throws Exception {
        Connection conn = getConn();
        ArrayList<Map<String, Object>> resultList = new ArrayList<>();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        if (paras != null && paras.length >= 0) {
            for (int i = 0; i < paras.length; i++) {
                preparedStatement.setObject(i + 1, paras[i]);
            }
        }

        ResultSet resultSet = preparedStatement.executeQuery();
        //得到的是列的数量
        int columnCount = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()) {
            HashMap<String, Object> strMap = new HashMap<>(10);
            for (int i = 0; i < columnCount; i++) {
                strMap.put(resultSet.getMetaData().getColumnLabel(i + 1), resultSet.getObject(i + 1));
            }
            resultList.add(strMap);
        }

        return resultList;
    }

    /**
     * 结合反射和泛型
     * @param tClass
     * @param sql
     * @param paras
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> executeQuery(Class<T> tClass, String sql, Object... paras) throws Exception {
        Connection conn = getConn();
        ArrayList<T> ts = new ArrayList<>();

        //SQL语句先进行预编译
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        if (paras != null && paras.length > 0) {
            //给占位符赋值
            for (int i = 0; i < paras.length; i++) {
                preparedStatement.setObject(i + 1, paras[i]);
            }
        }
        //执行SQL语句，返回结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        //拿到表的列数
        int columnCount = resultSet.getMetaData().getColumnCount();
        //此数组用于存放构造器参数类型的Class对象
        Class[] paraTypes = new Class[columnCount];
        //给Class参数类型数组赋值
        for (int i = 0; i < columnCount; i++) {
            //拿到构造方法
            String columnClassName = resultSet.getMetaData().getColumnClassName(i + 1);
            //反射，类的全路径，Class的类对象
            Class<?> aClass = Class.forName(columnClassName);
            paraTypes[i] = aClass;
        }
        //得到构造器
        Constructor<T> declaredConstructor = tClass.getDeclaredConstructor(paraTypes);
        Object[] objects = new Object[columnCount];
        while (resultSet.next()) {
            for (int i = 0; i < columnCount; i++) {
                objects[i] = resultSet.getObject(i + 1);
            }
            //根据构造器创建对象
            T t1 = declaredConstructor.newInstance(objects);
            ts.add(t1);
        }

        return ts;
    }

    public static String getPropertiesValue(String key) throws Exception {
        if (properties.containsKey(key)) {
            return properties.getProperty(key);
        } else {
            throw new KeyNotFoundException("配置文件没有对应的key：" + key);
        }
    }
}
