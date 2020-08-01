package dao.dust;

import entity.OrderInfo;

import java.util.List;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/28 15:16
 */
public interface OrderInfoDao {

    /**
     * 插入订单信息
     * @param orderInfo 订单信息实体类
     * @return
     */
    int insert(OrderInfo orderInfo);

    /**
     * 删除订单信息
     * @param orderId
     * @return
     */
    int delete(int orderId);

    /**
     * 查看订单信息
     * @param orderId
     * @return
     */
    int selectOne(int orderId);

    /**
     * 查看所有订单信息
     * @return
     */
    List<OrderInfo> selectAll();


}
