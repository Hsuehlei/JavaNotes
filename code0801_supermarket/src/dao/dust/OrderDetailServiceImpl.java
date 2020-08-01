package dao.dust;

import entity.OrderDetail;
import util.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/28 19:30
 */
public class OrderDetailServiceImpl implements OrderDetailService {
    private OrderDetailDao orderDetailDao;

    public OrderDetailServiceImpl(OrderDetailDao orderDetailDao) {
        this.orderDetailDao = orderDetailDao;
    }

    /**
     * 业务逻辑层
     * @param orderDetail
     * @return
     */
    @Override
    public int add(OrderDetail orderDetail) {
        //参数校验，返回值校验，异常处理机制，log日志
        Connection conn = null;
        try {
            conn = DbUtil.getConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //关闭事务的自动提交机制
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int num = 0;
        if (orderDetail != null) {
            try {
                num = orderDetailDao.insert(orderDetail);
                conn.commit();
            } catch (Exception e) {
                try {
                    conn.rollback();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
                e.printStackTrace();
            }
        } else {
            //log
            System.out.println("--------");
        }
        return num;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int edit(OrderDetail orderDetail) {
        return 0;
    }

    @Override
    public OrderDetail selectOne(int id) {
        return null;
    }

    @Override
    public List<OrderDetail> selectAll() {
        return null;
    }
}
