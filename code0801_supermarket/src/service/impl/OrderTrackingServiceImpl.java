package service.impl;

import dao.impl.OrderTrackingImpl;
import entity.OrderDetail;
import entity.OrderInfo;
import service.OrderTrackingService;

import java.util.List;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/31 19:49
 */
public class OrderTrackingServiceImpl implements OrderTrackingService {

    OrderTrackingImpl orderTracking = new OrderTrackingImpl();

    @Override
    public List<OrderInfo> goodsIdSelectInfo(int id) {
        List<OrderInfo> orderInfos = orderTracking.goodsIdSelectInfo(id);
        return orderInfos;
    }

    @Override
    public List<OrderDetail> goodsIdSelectDetail(int id) {
        List<OrderDetail> orderDetails = orderTracking.goodsIdSelectDetail(id);
        return orderDetails;
    }

    @Override
    public List<OrderInfo> vipIdSelectInfo(int id) {
        List<OrderInfo> orderInfos = orderTracking.vipIdSelectInfo(id);
        return orderInfos;
    }

    @Override
    public List<OrderDetail> vipIdSelectDetail(int id) {
        List<OrderDetail> orderDetails = orderTracking.vipIdSelectDetail(id);
        return orderDetails;
    }

}
