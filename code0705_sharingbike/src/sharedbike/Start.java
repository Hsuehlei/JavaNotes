package sharedbike;

import java.text.ParseException;
import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/4 19:07
 */
public class Start {

    public static void main(String[] args) throws ParseException {

        SharedBikeMgr sharedBikeMgr = new SharedBikeMgr();
        SharedBikeCompany[] arr = sharedBikeMgr.initial();

        startMenu(arr);


    }


    /**
     * 菜单切换
     */
    public static void startMenu(SharedBikeCompany[] arr) throws ParseException {

        System.out.println("欢迎使用迷你共享单车管理系统");
        System.out.println("**********************************");
        System.out.println("            1.投放Bike");
        System.out.println("            2.查看Bike");
        System.out.println("            3.删除Bike");
        System.out.println("            4.借出Bike");
        System.out.println("            5.归还Bike");
        System.out.println("            6.Bike排行榜");
        System.out.println("            7.退出");
        System.out.println("**********************************");
        System.out.print("请选择：");

        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("------>1.投放Bike");
                    SharedBikeDao.putBike(arr);
                    break;
                case 2:
                    System.out.println("------>2.查看Bike");
                    SharedBikeDao.selectAllBike(arr);
                    break;
                case 3:
                    System.out.println("------>3.删除Bike");
                    SharedBikeDao.deleteBike(arr);
                    break;
                case 4:
                    System.out.println("------>4.借出Bike");
                    SharedBikeDao.borrowBike(arr);
                    break;
                case 5:
                    System.out.println("------>5.归还Bike");
                    SharedBikeDao.returnBike(arr);
                    break;
                case 6:
                    System.out.println("------>6.Bike排行榜");
                    SharedBikeDao.lendLeaderBoard(arr);
                    break;
                case 7:
                    System.out.println("------>7.退出");
                    System.exit(0);
                    break;
                default:
                    System.out.println("您的输入有误！");
            }
        } else {
            System.out.println("您的输入不合法，请重新输入！");
        }
    }
}
