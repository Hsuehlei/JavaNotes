package sharedbike;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/4 19:27
 */
public class SharedBikeDao {


    /**
     * 请选择要操作的单车品牌
     */
    public static void operator() {
        System.out.println("1：ofo单车");
        System.out.println("2：halo单车");
        System.out.println("3：摩拜单车");
    }

    /**
     * 输入0返回
     */
    public static void returnHome(SharedBikeCompany[] arr) throws ParseException {

        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------");
        System.out.print("输入0返回：");
        if (sc.nextInt() == 0) {
            Start.startMenu(arr);
        } else {
            System.out.println("输入非法，请重新输入！");
        }
    }

    /**
     * @param arr 输出所有Bike信息
     */
    public static void selectAllBike(SharedBikeCompany[] arr) throws ParseException {

        for (int i = 0; i < arr.length; i++) {
            System.out.println("+------------------------------------------------+");
            System.out.println("| 公司序号 | 公司名称 | 公司单车数量 | 公司单车借出数量 |");
            System.out.println("+------------------------------------------------+");
            System.out.println("|\t" + arr[i].getBikeCompanyId() + "\t\t" + arr[i].getBikeCompany() + "\t\t\t" + arr[i].getSum() + "\t\t\t" + arr[i].getCount() + "\t\t |");
            System.out.println("+------------------------------------------------+");
            System.out.println("  单车序号   单车品牌   单车状态   借出时间  ");
            for (int j = 0, k = 0; j < arr[i].getSharedBikes().length; j++, k++) {
                if (arr[i].getSharedBikes()[k].getbName() != null) {
                    String status = (arr[i].getSharedBikes()[k].getStatus() == 1) ? "可借" : "已借出";
                    System.out.println("\t" + arr[i].getSharedBikes()[k].getBid() + "\t\t" + arr[i].getSharedBikes()[k].getbName() + "\t\t" + status + "\t\t" + arr[i].getSharedBikes()[k].getBorrowTime() + "\t\t");
                }
            }
        }
        returnHome(arr);
    }

    /**
     * 新增n辆某品牌单车
     * 定位新增位置 • 插入Bike信息，状态值为1(可借) l 难点提示 • 定位新增位置：第一个bike为null的位置
     */
    public static void putBike(SharedBikeCompany[] arr) throws ParseException {

        operator();
        Scanner sc = new Scanner(System.in);
        int newBikeCom = sc.nextInt();
        System.out.println("请录入要投放的数量：");
        int putBikeNum = sc.nextInt();
        String company;
        do {
            switch (newBikeCom) {
                case 1:
                    company = "ofo单车";
                    break;
                case 2:
                    company = "halo单车";
                    break;
                case 3:
                    company = "摩拜单车";
                    break;
                default:
                    company = "";
                    System.out.println("输入非法，请重新输入");
            }
        } while ("".equals(company));

        int oldBikeNum = arr[newBikeCom - 1].getSum();
        int newBikeNum = oldBikeNum + putBikeNum;

        SharedBike[] addSharedBike = new SharedBike[newBikeNum];

        for (int i = 0; i < arr[newBikeCom - 1].getSum(); i++) {
            addSharedBike[i] = arr[newBikeCom - 1].getSharedBikes()[i];
        }
        for (int i = arr[newBikeCom - 1].getSum(); i < newBikeNum; i++) {
            addSharedBike[i] = new SharedBike(i + 1, company + i, 1, "");
        }

        arr[newBikeCom - 1].setSharedBikes(addSharedBike);
        arr[newBikeCom - 1].setSum(arr[newBikeCom - 1].getSum() + putBikeNum);

        System.out.println("空间不足，已经参照配置进行扩容");
        System.out.println("投放" + putBikeNum + "辆" + company + "成功");
        returnHome(arr);
    }

    /**
     * 删除单车
     */
    public static void deleteBike(SharedBikeCompany[] arr) throws ParseException {
        operator();
        System.out.println("请选择要操作的单车品牌：");
        Scanner sc = new Scanner(System.in);

        int choice = sc.nextInt();
        String company;

        switch (choice) {
            case 1:
                company = "ofo单车";
                break;
            case 2:
                company = "halo单车";
                break;
            case 3:
                company = "摩拜单车";
                break;
            default:
                company = "";
                System.out.println("输入非法，请重新输入");
        }

        System.out.println("此" + company + "有共享单车如下：");
        System.out.println("  单车序号   单车品牌   单车状态   借出时间  ");
        for (int i = 0; i < arr[choice - 1].getSharedBikes().length; i++) {
            String status = (arr[choice - 1].getSharedBikes()[i].getStatus() == 1) ? "可借" : "已借出";
            System.out.println("\t" + arr[choice - 1].getSharedBikes()[i].getBid() + "\t\t" + arr[choice - 1].getSharedBikes()[i].getbName() + "\t\t" + status + "\t\t" + arr[choice - 1].getSharedBikes()[i].getBorrowTime() + "\t\t");
        }
        System.out.println("请录入要删除单车的编号：");
        int delNum = sc.nextInt();

        Boolean flag = false;
        for (int i = 0; i < arr[choice - 1].getSharedBikes().length; i++) {
            if (delNum == arr[choice - 1].getSharedBikes()[i].getBid()) {
                flag = true;
            }
        }

        if (flag) {
            if (arr[choice - 1].getSharedBikes()[delNum].getStatus() == 1) {
                for (int i = delNum; i < arr[choice - 1].getSharedBikes().length - 1; i++) {
                    arr[choice - 1].getSharedBikes()[delNum] = arr[choice - 1].getSharedBikes()[delNum + 1];
                    arr[choice - 1].getSharedBikes()[delNum].setBid(arr[choice - 1].getSharedBikes()[delNum].getBid()-1);

                }
                arr[choice - 1].getSharedBikes()[arr[choice - 1].getSharedBikes().length - 1] = new SharedBike();
                arr[choice - 1].setSum(arr[choice - 1].getSum() - 1);
                System.out.println("删除" + company + "公司下的" + arr[choice].getSharedBikes()[delNum].getbName() + "成功");
                returnHome(arr);
            } else {
                System.out.println("共享单车已借出，不允许删除");
                returnHome(arr);
            }
        } else {
            System.out.println("不存在指定Bike");
            returnHome(arr);
        }
    }

    /**
     * 借出Bike
     */
    public static void borrowBike(SharedBikeCompany[] arr) throws ParseException {
        operator();
        System.out.println("请选择要操作的单车品牌：");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        String company;
        switch (choice) {
            case 1:
                company = "ofo单车";
                break;
            case 2:
                company = "halo单车";
                break;
            case 3:
                company = "摩拜单车";
                break;
            default:
                company = "";
                System.out.println("输入非法，请重新输入");
        }
        System.out.println("此" + company + "有共享单车如下：");
        System.out.println("  单车序号   单车品牌   单车状态   借出时间  ");
        for (int i = 0; i < arr[choice - 1].getSharedBikes().length; i++) {
            String status = (arr[choice - 1].getSharedBikes()[i].getStatus() == 1) ? "可借" : "已借出";
            System.out.println("\t" + arr[choice - 1].getSharedBikes()[i].getBid() + "\t\t" + arr[choice - 1].getSharedBikes()[i].getbName() + "\t\t" + status + "\t\t" + arr[choice - 1].getSharedBikes()[i].getBorrowTime() + "\t\t");
        }

        System.out.print("请录入要借出的单车编号：");
        int borBikeId = sc.nextInt();
        sc.nextLine();
        System.out.print("请输入借出日期(2019-01-01 12:30:30)：");
        //println后面会有一个（\n）,在下一句nextLine()获取的那一行的最前面，故直接跳过不执行
        //解决办法：在nextLine()后面加一个nextLine()用来接收这个换行符
        String borrowTime = sc.nextLine();

//        arr[choice-1].setCount(arr[choice-1].getCount()+1);
        arr[choice-1].getSharedBikes()[borBikeId-1].setStatus(0);
        arr[choice-1].getSharedBikes()[borBikeId-1].setBorrowTime(borrowTime);
        System.out.println("借出" + company + "公司下的《" + arr[choice-1].getSharedBikes()[borBikeId-1].getbName() + "》成功");
        returnHome(arr);
    }

    /**
     * 归还Bike
     */
    public static void returnBike(SharedBikeCompany[] arr) throws ParseException {
        operator();
        System.out.println("请选择要操作的单车品牌：");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        String company;
        switch (choice) {
            case 1:
                company = "ofo单车";
                break;
            case 2:
                company = "halo单车";
                break;
            case 3:
                company = "摩拜单车";
                break;
            default:
                company = "";
                System.out.println("输入非法，请重新输入");
        }
        System.out.print("请录入要归还的单车编号：");
        int returnBikeId = sc.nextInt();
        sc.nextLine();
        if (arr[choice - 1].getSharedBikes()[returnBikeId-1].getStatus()!=1) {
            System.out.print("请录入归还时间(yyyy-MM-dd HH:mm:ss)：");
            System.out.print("您的借车时间为" + arr[choice-1].getSharedBikes()[returnBikeId-1].getBorrowTime());
            String returnDate = sc.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d1 = sdf.parse(arr[choice-1].getSharedBikes()[returnBikeId-1].getBorrowTime());
            Date d2 = sdf.parse(returnDate);

            double charge = (d1.getTime() - d2.getTime())/(60*60*1000.0);
            double cost;
            if (charge > 2) {
                cost = 5.0;
            } else if (charge > 1) {
                cost = 3.0;
            } else if (charge > 0){
                cost = 1.5;
            } else {
                charge = 0;
                cost = 0;
                System.out.println("归还时间错误，请仔细核对您的归还时间");
            }
            arr[choice-1].getSharedBikes()[returnBikeId-1].setStatus(1);
            arr[choice-1].setCount( arr[choice-1].getCount()+1);
            System.out.println("用车时间为《" + String.format("%.1f",charge) +"》小时，需要支付：" + cost +"元");
        } else {
            System.out.println("该车尚未借出，请仔细核对您要归还的单车序号");
        }
        returnHome(arr);
    }

    /**
     * 借出排行榜
     */
    public static void lendLeaderBoard(SharedBikeCompany[] arr) throws ParseException {
        int[] rank = new int[3];
        System.out.println("公司名称\t\t借出次数");
        for (int i = 0; i < arr.length; i++) {
            rank[i] = arr[i].getCount();
        }

        bubbleSort(rank);

        for (int i = 0; i < rank.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (rank[i]==arr[j].getCount()) {
                    System.out.println(arr[j].getBikeCompany() + "\t\t" + rank[i]);
                }
            }
        }
        returnHome(arr);
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] < arr[j+1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            //在一趟排序中，一次交换都没有发生过
            if (flag == false) {
                break;
            } else {
                //重置flag！！！进行下次判断
                flag = false;
            }
        }
    }

}