package startview.role.function;

import entity.OrderDetail;
import entity.OrderInfo;
import service.impl.OrderTrackingServiceImpl;
import startview.role.Cashier;

import java.util.List;
import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/31 19:41
 */
public class CashierOrderTrackingFunc {

    static OrderTrackingServiceImpl ots = new OrderTrackingServiceImpl();

    public static void goodsIdSelect(Scanner sc) {
        System.out.println("请输入要查询的商品编号：");
        int goodsId = sc.nextInt();
        List<OrderInfo> orderInfos = ots.goodsIdSelectInfo(goodsId);
        System.out.println("> 商品信息表");
        System.out.println("订单ID\t用户ID\t总金额\t订单完成时间\t\t\t\t支付方式");
        for (OrderInfo orderInfo : orderInfos) {
            System.out.println(orderInfo);
        }
        List<OrderDetail> orderDetails = ots.goodsIdSelectDetail(goodsId);
        System.out.println("> 商品详情表");
        System.out.println("订单详情ID\t订单ID\t商品ID\t商品数量");
        for (OrderDetail orderDetail : orderDetails) {
            System.out.println(orderDetail);
        }
        backToOrderTrackingMenu(sc);
    }

    public static void vipIdSelect(Scanner sc) {
        System.out.println("请输入要查询的会员ID：");
        int goodsId = sc.nextInt();
        List<OrderInfo> orderInfos = ots.vipIdSelectInfo(goodsId);
        System.out.println("> 商品信息表");
        System.out.println("订单ID\t用户ID\t总金额\t订单完成时间\t\t\t\t支付方式");
        for (OrderInfo orderInfo : orderInfos) {
            System.out.println(orderInfo);
        }
        List<OrderDetail> orderDetails = ots.vipIdSelectDetail(goodsId);
        System.out.println("> 商品详情表");
        System.out.println("订单详情ID\t订单ID\t商品ID\t商品数量");
        for (OrderDetail orderDetail : orderDetails) {
            System.out.println(orderDetail);
        }
        backToOrderTrackingMenu(sc);
    }

    public static void backToOrderTrackingMenu(Scanner sc) {
        System.out.println();
        String choice = Cashier.orderTracking(sc);
        Cashier.orderTrackingChoice(choice,sc);
    }
}
