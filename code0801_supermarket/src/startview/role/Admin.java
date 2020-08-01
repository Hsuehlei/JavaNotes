package startview.role;

import startview.Start;

import java.util.Scanner;

import static startview.role.function.AdminGoodsInfoFunc.*;
import static startview.role.function.AdminGoodsTypeFunc.*;
import static startview.role.function.AdminVipInfoFunc.*;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/29 14:52
 */
public class Admin {

    public static void adminMenu(Scanner sc) {
        System.out.println("欢迎使用超市管理系统");
        System.out.println("1.商品类型管理");
        System.out.println("2.商品管理");
        System.out.println("3.会员管理");
        System.out.println("4.退出");
        String choice = Start.choiceCheck(sc);
        adminMenuChoice(choice,sc);
    }

    public static void adminMenuChoice(String choice,Scanner sc) {
        switch (choice) {
            case "1":
                choice = goodsTypeManagement(sc);
                goodsTypeManagementChoice(choice,sc);
                break;
            case "2":
                choice = goodsInfoManagement(sc);
                goodsInfoManagementChoice(choice,sc);
                break;
            case "3":
                choice = vipManagement(sc);
                vipManagementChoice(choice,sc);
                break;
            case "4":
                Start.exit();
                break;
            default:
                System.out.println("选项不存在，请重新输入");
                choice = Start.choiceCheck(sc);
                adminMenuChoice(choice,sc);
        }
    }

    /**
     * 商品类型管理
     * @param sc
     * @return
     */
    public static String goodsTypeManagement(Scanner sc) {
        System.out.println();
        System.out.println("> 商品类型管理");
        System.out.println("1.添加商品类型信息");
        System.out.println("2.修改商品类型信息");
        System.out.println("3.查询商品类型信息");
        System.out.println("4.删除商品类型信息");
        System.out.println("5.查询父类型的子类型");
        System.out.println("6.返回");
        return Start.choiceCheck(sc);
    }

    public static void goodsTypeManagementChoice(String choice,Scanner sc) {
        switch (choice) {
            case "1":
                System.out.println("> 添加商品类型信息");
                addType(sc);
                break;
            case "2":
                System.out.println("> 修改商品类型信息");
                editType(sc);
                break;
            case "3":
                System.out.println("> 查询商品类型信息");
                selectAllType(sc);
                break;
            case "4":
                System.out.println("> 删除商品类型信息");
                deleteType(sc);
                break;
            case "5":
                System.out.println("> 查询父类型的子类型");
                querySubclass(sc);
                break;
            case "6":
                System.out.println("> 返回");
                backHere(sc);
                break;
            default:
                System.out.println("选项不存在，请重新输入");
                choice = Start.choiceCheck(sc);
                goodsTypeManagementChoice(choice,sc);
        }
    }

    /**
     * 商品信息管理
     * @param sc
     * @return
     */
    public static String goodsInfoManagement(Scanner sc) {
        System.out.println();
        System.out.println("> 商品管理");
        System.out.println("1.添加商品信息");
        System.out.println("2.修改商品信息");
        System.out.println("3.查询一个商品信息");
        System.out.println("4.查询全部商品信息");
        System.out.println("5.删除商品信息");
        System.out.println("6.返回");
        return Start.choiceCheck(sc);
    }

    public static void goodsInfoManagementChoice(String choice, Scanner sc) {
        switch (choice) {
            case "1":
                System.out.println("> 添加商品信息");
                addGoods(sc);
                break;
            case "2":
                System.out.println("> 修改商品信息");
                editGoods(sc);
                break;
            case "3":
                System.out.println("> 查询一个商品信息");
                selectOneGoods(sc);
                break;
            case "4":
                System.out.println("> 查询全部商品信息");
                selectAllGoods(sc);
                break;
            case "5":
                System.out.println("> 删除商品信息");
                deleteGoods(sc);
                break;
            case "6":
                System.out.println("> 返回");
                backHere(sc);
                break;
            default:
                System.out.println("选项不存在，请重新输入");
                choice = Start.choiceCheck(sc);
                goodsInfoManagementChoice(choice,sc);
        }
    }

    /**
     * 会员信息管理
     * @param sc
     * @return
     */
    public static String vipManagement(Scanner sc) {
        System.out.println("> 会员管理");
        System.out.println("1.添加会员");
        System.out.println("2.修改会员信息");
        System.out.println("3.查询会员信息");
        System.out.println("4.查询全部会员信息");
        System.out.println("5.会员充值");
        System.out.println("6.删除会员信息");
        System.out.println("7.返回");
        return Start.choiceCheck(sc);
    }

    public static void vipManagementChoice(String choice, Scanner sc) {
        switch (choice) {
            case "1":
                System.out.println("> 添加会员");
                addVip(sc);
                break;
            case "2":
                System.out.println("> 修改会员信息");
                editVip(sc);
                break;
            case "3":
                System.out.println("> 查询会员信息");
                selectOneVip(sc);
                break;
            case "4":
                System.out.println("> 查询全部会员信息");
                selectAllVip(sc);
                break;
            case "5":
                System.out.println("> 会员充值");
                vipRecharge(sc);
                break;
            case "6":
                System.out.println("> 删除会员信息");
                deleteVip(sc);
                break;
            case "7":
                System.out.println("> 返回");
                backHere(sc);
                break;
            default:
                System.out.println("选项不存在，请重新输入");
                choice = Start.choiceCheck(sc);
                vipManagementChoice(choice, sc);
        }
    }

    /**
     * 返回到管理员功能主界面
     * @param sc
     */
    public static void backHere(Scanner sc) {
        System.out.println();
        adminMenu(sc);
    }
}
