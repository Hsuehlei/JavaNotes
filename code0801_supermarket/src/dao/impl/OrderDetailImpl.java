package dao.impl;

import dao.BaseDao;
import entity.OrderDetail;
import util.DbUtil;

import java.util.List;
import java.util.Map;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/28 19:21
 */
public class OrderDetailImpl implements BaseDao<OrderDetail> {
    @Override
    public int insert(OrderDetail orderDetail) throws Exception {
        int orderId = orderDetail.getOrderId();
        int buyId = orderDetail.getBuyId();
        int buyCount = orderDetail.getBuyCount();
        String sql = "INSERT INTO t_order_detail(orderid,buyid,buycount) VALUES (?,?,?)";
        int i = DbUtil.executeUpdate(sql,orderId,buyId,buyCount);
        return i;
    }

    /**
     * 添加订单信息到订单详情表
     * 现金支付
     * @param orderId
     * @param buyId
     * @param buyCount
     * @return
     * @throws Exception
     */
    public int insert(int orderId, int buyId, int buyCount) throws Exception {
        String sql = "INSERT INTO t_order_detail(orderid, buyid, buycount) VALUES (?, ?, ?)";
        int i = DbUtil.executeUpdate(sql, orderId, buyId, buyCount);
        return i;
    }

    @Override
    public int delete(int id) throws Exception {
        String sql = "DELETE FROM t_order_detail WHERE id = ?";
        int i = DbUtil.executeUpdate(sql,id);
        return i;
    }

    @Override
    public int update(OrderDetail orderDetail) throws Exception {
        int id = orderDetail.getId();
        int buyCount = orderDetail.getBuyCount();
        String sql = "UPDATE t_order_detail SET buycount = ? WHERE id = ?";
        int i = DbUtil.executeUpdate(sql,buyCount,id);
        return i;
    }

    /**
     * OrderDetail
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> selectOne(int id) throws Exception {
        String sql = "SELECT buycount FROM t_order_detail WHERE id = ?";
        List<Map<String, Object>> maps = DbUtil.executeQuery(sql, id);
        if (maps.size() > 0) {
//            Map<String, Object> map = maps.get(0);
//        Object o = map.get("buycount");
            return maps.get(0);
        } else {
            return null;
        }

    }

    @Override
    public List<OrderDetail> selectAll() throws Exception {
        String sql = "SELECT * FROM t_order_detail";
        List<OrderDetail> orderDetails = DbUtil.executeQuery(OrderDetail.class, sql);

        return orderDetails;
    }
}
