package dao.impl;

import entity.OrderInfo;
import entity.VipInfo;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/28 21:52
 */
public class OrderInfoImplTest {

    @Test
    public void insert() throws Exception {
        OrderInfoImpl orderInfoImpl = new OrderInfoImpl();
        OrderInfo orderInfo = new OrderInfo(1,new BigDecimal(35),true);
        System.out.println(orderInfoImpl.insert(orderInfo));
    }

    @Test
    public void delete() throws Exception {
        OrderInfoImpl orderInfoImpl = new OrderInfoImpl();
        System.out.println(orderInfoImpl.delete(4));
    }

    @Test
    public void update() {
    }

    @Test
    public void selectOne() throws Exception {
        OrderInfoImpl orderInfoImpl = new OrderInfoImpl();
        System.out.println(orderInfoImpl.selectOne(3));
    }

    @Test
    public void selectAll() throws Exception {
        OrderInfoImpl orderInfoImpl = new OrderInfoImpl();
        List<OrderInfo> orderInfos = orderInfoImpl.selectAll();
        System.out.println(orderInfos);
    }

    @Test
    public void vipRecharge() {
        int vipId = 5;
//        BigDecimal rechargeAmount = new BigDecimal(88);

        List<VipInfo> vipInfos = null;
        try {
             vipInfos = new VipInfoImpl().recharge(vipId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(vipInfos);
    }
}