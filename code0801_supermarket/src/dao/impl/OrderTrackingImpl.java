package dao.impl;

import entity.OrderDetail;
import entity.OrderInfo;
import util.DbUtil;

import java.util.List;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/31 20:21
 */
public class OrderTrackingImpl {
    //SELECT * FROM t_order_detail WHERE buyid = 1
    //SELECT t.orderid,userid,ordertotalprice,ordertime,paymenttype FROM t_order_detail t,t_order_info WHERE buyid = 1 AND t.orderid = t_order_info.orderid

    public List<OrderInfo> goodsIdSelectInfo(int id) {
        String sql = "SELECT t.orderid,userid,ordertotalprice,ordertime,paymenttype FROM t_order_detail t,t_order_info " +
                "WHERE buyid = ? AND t.orderid = t_order_info.orderid";
        List<OrderInfo> orderInfos = null;
        try {
            orderInfos = DbUtil.executeQuery(OrderInfo.class, sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderInfos;
    }

    public List<OrderDetail> goodsIdSelectDetail(int id) {
        String sql = "SELECT * FROM t_order_detail WHERE buyid = ?";
        List<OrderDetail> orderDetails = null;
        try {
            orderDetails = DbUtil.executeQuery(OrderDetail.class, sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderDetails;
    }

    //SELECT * FROM t_order_info WHERE userid = 7
    //SELECT id,t.orderid,buyid,buycount FROM t_order_info t,t_order_detail WHERE userid = 7 AND t.orderid = t_order_detail.orderid
    public List<OrderInfo> vipIdSelectInfo(int id) {
        String sql = "SELECT * FROM t_order_info WHERE userid = ?";
        List<OrderInfo> orderInfos = null;
        try {
            orderInfos = DbUtil.executeQuery(OrderInfo.class, sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderInfos;
    }

    public List<OrderDetail> vipIdSelectDetail(int id) {
        String sql = "SELECT id,t.orderid,buyid,buycount FROM t_order_info t,t_order_detail WHERE userid = ? AND " +
                "t.orderid = t_order_detail.orderid";
        List<OrderDetail> orderDetails = null;
        try {
            orderDetails = DbUtil.executeQuery(OrderDetail.class, sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderDetails;
    }
}
