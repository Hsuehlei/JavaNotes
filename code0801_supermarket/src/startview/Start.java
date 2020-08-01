package startview;

import java.util.Scanner;

import static startview.role.Admin.*;
import static startview.role.Cashier.*;


/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/29 11:23
 */
public class Start {

    public static final String ADMIN_USER_NAME = "admin";
    public static final String ADMIN_PASSWORD = "123456";
    public static final String CASHIER_USER_NAME = "cashier";
    public static final String CASHIER_PASSWORD = "123456";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        startMenu();
        String choice = choiceCheck(sc);
        startChoice(choice, sc);
    }

    public static String choiceCheck(Scanner sc) {
        System.out.print("> 请选择：");
        String choice = sc.next();
        while (!choice.matches("\\d")) {
            System.out.println("异常输入，请重新输入");
            System.out.print("> 请选择：");
            choice = sc.next();
        }
        return choice;
    }

    public static void startMenu() {
        //商品类型管理、商品管理、会员管理、购买管理、订单查询、排行统计
        System.out.println("欢迎使用超市管理系统");
        System.out.println("1.登录");
        System.out.println("2.退出");
    }

    public static void startChoice(String choice,Scanner sc) {
        switch (choice) {
            case "1":
                login(sc);
                break;
            case "2":
                exit();
                break;
            default:
                System.out.println("选项不存在，请重新输入");
                choice = choiceCheck(sc);
                startChoice(choice,sc);
        }
    }

    public static void login(Scanner sc) {
        System.out.println("> 用户名：");
        String userName = sc.next();
        System.out.println("> 密  码：");
        String password = sc.next();

        if (userName.equals(ADMIN_USER_NAME) && password.equals(ADMIN_PASSWORD)) {
            System.out.println("> 欢迎您：" + userName);
            System.out.println();
            adminMenu(sc);
        } else if (userName.equals(CASHIER_USER_NAME) && password.equals(CASHIER_PASSWORD)) {
            System.out.println("> 欢迎您：" + userName);
            System.out.println();
            cashierMenu(sc);
        } else {
            System.out.println("> 用户名或密码错误");
            System.out.println("> 2秒后跳转到主页面");
            System.out.println();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startMenu();
            String choice = choiceCheck(sc);
            startChoice(choice, sc);
        }
    }

    public static void exit() {
        System.out.println("> 正在退出");
        try {
            Thread.sleep(150);
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
