package startview.role.function;

import dao.impl.VipInfoImpl;
import entity.ShoppingCart;
import service.impl.BuyManagementServiceImpl;
import startview.role.Cashier;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/30 20:25
 */
public class CashierBuyManagementFunc {

    static BuyManagementServiceImpl buyManagementService = new BuyManagementServiceImpl();

    public static void addGoods(Scanner sc) {
        boolean flag = false;
        System.out.println("请输入要加购物车的商品信息：");
        System.out.println("商品ID：");
        int goodsId = sc.nextInt();
        Map<String, Object> map = buyManagementService.selectStock(goodsId);
        if (map == null) {
            System.out.println("> 该商品不存在");
            System.out.println("> 请重新选择");
            System.out.println();
            String choice = Cashier.buyManagement(sc);
            Cashier.buyManagementChoice(choice, sc);
        } else {
            System.out.println("商品数量：");
            int count = sc.nextInt();
            if ((int) map.get("goodscount") < count) {
                System.out.println("> 该商品库存数量不足");
                System.out.println("> 请重新选择");
                String choice = Cashier.buyManagement(sc);
                Cashier.buyManagementChoice(choice, sc);
            } else {
                flag = buyManagementService.add(goodsId, count);
            }
        }

        if (flag) {
            System.out.println("> 成功加入购物车");
            shoppingCartChoice(sc);
        }
    }

    public static void editGoodsCount(Scanner sc) {
        System.out.println("请输入要修改的商品ID：");
        int goodsId = sc.nextInt();
        System.out.println("请输入新的商品数量：");
        int newGoodsCount = sc.nextInt();
        int edit = buyManagementService.edit(goodsId, newGoodsCount);
        if (edit == 1) {
            System.out.println("> 修改成功");
            System.out.println("> 1秒后返回");
        } else {
            System.out.println("> 修改失败");
            System.out.println("> 请重试");
        }
        backToBuyManagementMenu(sc);
    }

    public static void deleteGoods(Scanner sc) {
        System.out.println("请输入要删除的商品ID：");
        int goodsId = sc.nextInt();
        boolean delete = buyManagementService.delete(goodsId);
        if (delete) {
            System.out.println("> 删除成功");
            System.out.println("> 1秒后返回");
        } else {
            System.out.println("> 删除失败");
            System.out.println("> 请重试");
        }
        backToBuyManagementMenu(sc);
    }

    public static void showShoppingCart(Scanner sc) {
        List<ShoppingCart> shoppingCarts = buyManagementService.selectAll();
        BigDecimal totalPrice = new BigDecimal(0);
        System.out.println("> 当前购物车中的商品如下：");
        System.out.println("商品编号\t商品名\t单价\t数量\t折扣\t金额");
        for (ShoppingCart shoppingCart : shoppingCarts) {
            System.out.println(shoppingCart);
            totalPrice = totalPrice.add(shoppingCart.getTotalPrice());
        }
        backToBuyManagementMenu(sc);
    }

    public static void backToBuyManagementMenu(Scanner sc) {
        String choice = Cashier.buyManagement(sc);
        Cashier.buyManagementChoice(choice, sc);
    }

    /**
     * 购物结算选项
     *
     * @param sc
     */
    public static void shoppingCartChoice(Scanner sc) {
        System.out.println("> 请问继续购买还是去结算(0继续购买，1结算,2返回)：");
        String choice = sc.next();
        if ("0".equals(choice)) {
            addGoods(sc);
        } else if ("1".equals(choice)) {
            settlement(sc);
        } else if ("2".equals(choice)) {
            backToBuyManagementMenu(sc);
        } else {
            System.out.println("> 选项不存在");
            System.out.println("> 请重新输入");
            shoppingCartChoice(sc);
        }
    }

    /**
     * 商品结算
     */
    public static void settlement(Scanner sc) {
        List<ShoppingCart> shoppingCarts = buyManagementService.selectAll();
        if (shoppingCarts.size() != 0) {
            BigDecimal totalPrice = new BigDecimal(0);
            System.out.println("> 当前购物车中的商品如下：");
            System.out.println("商品编号\t商品名\t数量\t折扣\t单价\t总金额");
            for (ShoppingCart shoppingCart : shoppingCarts) {
                System.out.println(shoppingCart);
                totalPrice = totalPrice.add(shoppingCart.getTotalPrice());
            }
            System.out.println("> 当前总金额为：" + totalPrice + "元");
            System.out.println("请选择支付方式(0现金，1刷卡，2返回)：");
            String choice = sc.next();
            if ("0".equals(choice)) {
                //现金支付
                int i = buyManagementService.cashPayment();
                if (i == 1) {
                    System.out.println("> 支付成功");
                    System.out.println("> 欢迎下次光临");
                    //支付后清空购物车
                    buyManagementService.emptyShoppingCart();
                } else {
                    System.out.println("> 支付失败");
                    System.out.println("> 请重试");
                    settlement(sc);
                }
                backToBuyManagementMenu(sc);
            } else if ("1".equals(choice)) {
                //刷卡支付
                cardPayment(sc);
            } else if ("2".equals(choice)) {
                //返回
                backToBuyManagementMenu(sc);
            } else {
                System.out.println("> 选项不存在");
                System.out.println("> 请重新输入");
            }
        } else {
            System.out.println();
            System.out.println("> 购物车空空如也");
            System.out.println("> 请先挑选商品再结算");
            backToBuyManagementMenu(sc);
        }
    }

    public static void cardPayment(Scanner sc) {
        System.out.println("请输入会员ID：");
        int userId = sc.nextInt();
        try {
            Map<String, Object> map = new VipInfoImpl().selectOne(userId);
            if (map == null) {
                System.out.println("> 该会员不存在");
                System.out.println("> 请重试");
                cardPayment(sc);
            } else {
                System.out.println("请输入密码：");
                String password = sc.next();
                int i = buyManagementService.passwordCheck(userId, password);
                if (i == 1) {
                    int x = buyManagementService.vipCardPayment(userId);
                    if (x == 1) {
                        System.out.println("> 支付成功");
                        System.out.println("> 1秒后返回");
                        Thread.sleep(1000);
                        backToBuyManagementMenu(sc);
                    } else if (x == 2) {
                        System.out.println("> 支付失败");
                        System.out.println("> 账户余额不足");
                        System.out.println("> 请充值或换支付方式");
                        backToBuyManagementMenu(sc);
                    }
                } else {
                    System.out.println("> 账号或密码错误");
                    System.out.println("> 请重试");
                    cardPayment(sc);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
