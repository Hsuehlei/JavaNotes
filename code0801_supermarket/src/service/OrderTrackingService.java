package service;

import entity.OrderDetail;
import entity.OrderInfo;
import entity.VipInfo;

import java.util.List;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/31 19:47
 */
public interface OrderTrackingService {

    /**
     * 查询所有订单
     * @param id 商品编号
     * @return
     */
    List<OrderInfo> goodsIdSelectInfo(int id);

    /**
     * 查询所有订单
     * @param id
     * @return
     */
    List<OrderDetail> goodsIdSelectDetail(int id);

    /**
     * 查询所有订单
     * @param id 会员编号
     * @return
     */
    List<OrderInfo> vipIdSelectInfo(int id);

    /**
     * 查询所有订单
     * @param id
     * @return
     */
    List<OrderDetail> vipIdSelectDetail(int id);

}
