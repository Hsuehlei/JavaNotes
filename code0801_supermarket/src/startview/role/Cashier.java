package startview.role;

import startview.Start;

import java.util.Scanner;

import static startview.role.function.CashierBuyManagementFunc.*;
import static startview.role.function.CashierOrderTrackingFunc.*;
import static startview.role.function.CashierRankFunc.*;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/29 14:54
 */
public class Cashier {

    public static void cashierMenu(Scanner sc) {
        System.out.println("欢迎使用超市管理系统");
        System.out.println("1.购买管理");
        System.out.println("2.订单管理");
        System.out.println("3.排行统计");
        System.out.println("4.退出");
        String choice = Start.choiceCheck(sc);
        cashierMenuChoice(choice,sc);
    }

    public static void cashierMenuChoice(String choice, Scanner sc) {
        switch (choice) {
            case "1":
                choice = buyManagement(sc);
                buyManagementChoice(choice,sc);
                break;
            case "2":
                choice = orderTracking(sc);
                orderTrackingChoice(choice,sc);
                break;
            case "3":
                choice = rankStatistics(sc);
                rankStatisticsChoice(choice,sc);
                break;
            case "4":
                Start.exit();
                break;
            default:
                System.out.println("选项不存在，请重新输入");
                choice = Start.choiceCheck(sc);
                cashierMenuChoice(choice,sc);
        }
    }

    public static String buyManagement(Scanner sc) {
        System.out.println();
        System.out.println("> 购买管理");
        System.out.println("1.添加商品");
        System.out.println("2.修改商品数量");
        System.out.println("3.删除购物车商品");
        System.out.println("4.查看购物车");
        System.out.println("5.结算");
        System.out.println("6.返回");
        return Start.choiceCheck(sc);
    }
    public static void buyManagementChoice(String choice, Scanner sc) {
        switch (choice) {
            case "1":
                System.out.println("> 添加商品");
                addGoods(sc);
                break;
            case "2":
                System.out.println("> 修改商品数量");
                editGoodsCount(sc);
                break;
            case "3":
                System.out.println("> 删除购物车商品");
                deleteGoods(sc);
                break;
            case "4":
                System.out.println("> 查看购物车");
                showShoppingCart(sc);
                break;
            case "5":
                System.out.println("> 结算");
                settlement(sc);
                break;
            case "6":
                System.out.println("> 返回");
                backHere(sc);
                break;
            default:
                System.out.println("选项不存在，请重新输入");
                choice = Start.choiceCheck(sc);
                buyManagementChoice(choice, sc);
        }
    }

    public static String orderTracking(Scanner sc) {
        System.out.println();
        System.out.println("> 订单查询");
        System.out.println("1.商品编号查询");
        System.out.println("2.会员编号查询");
        System.out.println("3.返回");
        return Start.choiceCheck(sc);
    }
    public static void orderTrackingChoice(String choice, Scanner sc) {
        switch (choice) {
            case "1":
                System.out.println("> 商品编号查询");
                goodsIdSelect(sc);
                break;
            case "2":
                System.out.println("> 会员编号查询");
                vipIdSelect(sc);
                break;
            case "3":
                System.out.println("> 返回");
                backHere(sc);
                break;
            default:
                System.out.println("选项不存在，请重新输入");
                choice = Start.choiceCheck(sc);
                buyManagementChoice(choice, sc);
        }
    }

    public static String rankStatistics(Scanner sc) {
        System.out.println();
        System.out.println("> 排行统计");
        System.out.println("1.商品类型销量排行");
        System.out.println("2.月份筛选销量排行");
        System.out.println("3.返回");
        return Start.choiceCheck(sc);
    }
    public static void rankStatisticsChoice(String choice, Scanner sc) {
        switch (choice) {
            case "1":
                System.out.println("> 商品类型销量排行");
                selectByGoodsId(sc);
                break;
            case "2":
                System.out.println("> 月份筛选销量排行");
                selectByMonth(sc);
                break;
            case "3":
                System.out.println("> 返回");
                backHere(sc);
                break;
            default:
                System.out.println("选项不存在，请重新输入");
                choice = Start.choiceCheck(sc);
                buyManagementChoice(choice, sc);
        }
    }

    public static void backHere(Scanner sc) {
        System.out.println();
        cashierMenu(sc);
    }
}
