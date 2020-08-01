package dao.impl;


import dao.dust.OrderDetailImpls;
import entity.OrderDetail;
import org.junit.Test;

import java.util.List;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/27 21:04
 */
public class OrderDetailImplTest {

    @Test
    public void testInsert() throws Exception {
        OrderDetailImpls orderDetailImpl = new OrderDetailImpls();
        OrderDetail orderDetail = new OrderDetail(7, 8, 9, 9);
        System.out.println(orderDetailImpl.insert(orderDetail));
    }

    @Test
    public void testDelete() throws Exception {
        OrderDetailImpls orderDetailImpl = new OrderDetailImpls();
        orderDetailImpl.delete(8);
    }

    @Test
    public void testUpdate() throws Exception {
        OrderDetailImpls orderDetail = new OrderDetailImpls();
        OrderDetail orderDetail1 = new OrderDetail(4,10,10,10);
        orderDetail.update(orderDetail1);
    }

    @Test
    public void testSelectOne() throws Exception {
        OrderDetailImpls orderDetail = new OrderDetailImpls();
        System.out.println(orderDetail.selectOne(2));
    }

    @Test
    public void testSelectAll() throws Exception {
        OrderDetailImpls orderDetail = new OrderDetailImpls();
        List<OrderDetail> orderDetails = orderDetail.selectAll();
        System.out.println(orderDetails);
    }
}