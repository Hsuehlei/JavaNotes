package dao.impl;

import dao.BaseDao;
import entity.OrderInfo;
import util.DbUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/28 15:35
 */
public class OrderInfoImpl implements BaseDao<OrderInfo> {

    /**
     * 订单ID int 自增  唯一
     * 用户ID int 非空
     * 订单总金额	decimal非空
     * 下单时间 datetime 非空
     * 支付类型 tinyint(2) （0-现金or  1-余额）非空
     */
    @Override
    public int insert(OrderInfo orderInfo) throws Exception {
        int userId = orderInfo.getUserId();
        BigDecimal orderTotalPrice = orderInfo.getOrderTotalPrice();
        boolean paymentType = orderInfo.getPaymentType();
        String sql = "INSERT INTO t_order_info(userid,ordertotalprice,ordertime,paymenttype) VALUES(?,?,NOW(),?)";
        int i = DbUtil.executeUpdate(sql,userId,orderTotalPrice,paymentType);
        return i;
    }

//    /**
//     * 添加订单信息到订单信息表
//     * @param userId
//     * @param orderTotalPrice
//     * @return
//     * @throws Exception
//     */
//    public int insert(int userId, BigDecimal orderTotalPrice) throws Exception {
//        String sql = "INSERT INTO t_order_info(userid, ordertotalprice, ordertime, paymenttype) VALUES (?, ?, NOW(), 0)";
//        int i = DbUtil.executeUpdate(sql, userId, orderTotalPrice);
//        return i;
//    }

    /**
     * 添加订单信息到订单信息表，并获取刚刚生成的主键orderid
     * 现金支付
     * @param orderTotalPrice
     * @return
     * @throws Exception
     */
    public int getKey(BigDecimal orderTotalPrice) throws Exception {
        String sql = "INSERT INTO t_order_info(userid, ordertotalprice, ordertime, paymenttype) VALUES (7, ?, NOW(), 0)";
        int key = DbUtil.executeGetKey(sql, orderTotalPrice);
        return key;
    }

    public int getKey(int userId, BigDecimal orderTotalPrice) throws Exception {

        String sql = "INSERT INTO t_order_info(userid, ordertotalprice, ordertime, paymenttype) VALUES (?, ?, NOW(), 1)";
        int key = DbUtil.executeGetKey(sql, userId, orderTotalPrice);
        return key;
    }

    @Override
    public int delete(int id) throws Exception {
        String sql = "DELETE FROM t_order_info WHERE orderid = ?";
        int i = DbUtil.executeUpdate(sql,id);
        return i;
    }

    @Override
    public int update(OrderInfo orderInfo) throws Exception {
        return 0;
    }

    @Override
    public Map<String, Object> selectOne(int id) throws Exception {
        String sql = "SELECT ordertotalprice FROM t_order_info WHERE orderid = ?";
        List<Map<String, Object>> maps = DbUtil.executeQuery(sql, id);
        if (maps.size() > 0) {
            return maps.get(0);
        } else {
            return null;
        }

    }

    @Override
    public List<OrderInfo> selectAll() throws Exception {
        String sql = "SELECT * FROM t_order_info";
        List<OrderInfo> orderInfos = DbUtil.executeQuery(OrderInfo.class, sql);
        return orderInfos;
    }
}
