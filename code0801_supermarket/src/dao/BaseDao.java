package dao;

import java.util.List;
import java.util.Map;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/28 19:18
 */
public interface BaseDao<T> {

    /**
     * 插入记录
     * @param t
     * @return
     * @throws Exception
     */
    int insert(T t) throws Exception;

    /**
     * 删除记录
     * @param id
     * @return
     * @throws Exception
     */
    int delete(int id) throws Exception;

    /**
     * 更新记录
     * @param t
     * @return
     * @throws Exception
     */
    int update(T t) throws Exception;

    /**
     * 查询一条记录
     * @param id
     * @return
     * @throws Exception
     */
    Map<String, Object> selectOne(int id) throws Exception;

    /**
     * 查询所有记录
     * @return
     * @throws Exception
     */
    List<T> selectAll() throws Exception;
}
