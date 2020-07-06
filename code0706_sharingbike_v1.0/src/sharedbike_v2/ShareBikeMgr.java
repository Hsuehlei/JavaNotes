package sharedbike_v2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/6 19:58
 */
public class ShareBikeMgr {

    public void userSelect(Scanner sc, ShareBikeCompany[] shareBikeCompanies) {
        System.out.println("欢迎使用迷你共享单车管理系统");
        String answer = "Y";
        while ("Y".equalsIgnoreCase(answer)) {
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

            int num = sc.nextInt();
            switch (num) {
                case 1:
                    putBike(sc, shareBikeCompanies);
                    break;
                case 2:
                    selectBike(shareBikeCompanies);
                    break;
                case 3:
                    deleteBike(sc, shareBikeCompanies);
                    break;
                case 4:
                    lendBike(sc, shareBikeCompanies);
                    break;
                case 5:
                    returnBike(sc, shareBikeCompanies);
                    break;
                case 6:
                    rankBike(shareBikeCompanies);
                    break;
                case 7:
                    systemExit();
                    break;
                default:
                    System.out.println("选项不存在，请重新输入");
            }
            //利用answer的值来控制循环的启停
            System.out.println("是否继续（Y/N）：");
            answer = sc.next();
        }

    }

    private void putBike(Scanner sc, ShareBikeCompany[] shareBikeCompanies) {
        System.out.println("------>1.投放Bike");
        companyOperator();
        int num = sc.nextInt();
        boolean flag = true;
        do {
            if (num > shareBikeCompanies.length || num < 0) {
                System.out.println("选项不存在，请重新输入");
            } else {
                ShareBike shareBike = new ShareBike();
                System.out.println("请输入单车ID：");
                shareBike.setBid(sc.nextInt());
                System.out.println("请输入单车名字编号：");
                shareBike.setbName(sc.next());
                switch (num) {
                    case 1:
                        shareBikeCompanies[0].putBike(shareBike);
                        break;
                    case 2:
                        shareBikeCompanies[1].putBike(shareBike);
                        break;
                    default:
                        shareBikeCompanies[2].putBike(shareBike);
                        break;

                }
                flag = false;
            }
        } while (flag);
    }

    private void selectBike(ShareBikeCompany[] shareBikeCompanies) {
        System.out.println("------>2.查看Bike");
        for (ShareBikeCompany shareBikeCompany : shareBikeCompanies) {
            System.out.println("----------------------------------");
            System.out.println("|公司序号|公司名称|公司单车数量|单车借出次数 ");
            System.out.println("----------------------------------");
            System.out.print("    " + shareBikeCompany.getId());
            System.out.print("      " + shareBikeCompany.getBikeCompanyName());
            System.out.print("       " + shareBikeCompany.getSum());
            System.out.println("        " + shareBikeCompany.getCount());
            System.out.println("-----------------------------------");
            ShareBike[] shareBikes = shareBikeCompany.getShareBikes();

            System.out.println("|单车序号|单车品牌|单车状态|借出时间|");
            for (int i = 0; i < shareBikeCompany.getSum(); i++) {
                System.out.print("     " + shareBikes[i].getBid());
                System.out.print("  " + shareBikes[i].getbName());
                System.out.print("    " + shareBikes[i].getStatus());
                System.out.print("  " + shareBikes[i].getBorrowTime());
                System.out.println();
            }
            System.out.println();
        }

    }

    private void deleteBike(Scanner sc, ShareBikeCompany[] shareBikeCompanies) {
        System.out.println("------>3.删除Bike");
        companyOperator();
        int num = sc.nextInt();
        boolean flag = true;
        do {
            System.out.println("请输入删除单车序号：");
            int id = sc.nextInt();
            if (num > shareBikeCompanies.length || num < 0) {
                System.out.println("选项不存在，请重新输入");
            } else {
                switch (num) {
                    case 1:
                        shareBikeCompanies[0].deleteBike(id);
                        break;
                    case 2:
                        shareBikeCompanies[1].deleteBike(id);
                        break;
                    default:
                        shareBikeCompanies[2].deleteBike(id);
                        break;
                }
                flag = false;
            }
        } while (flag);
    }

    private void lendBike(Scanner sc, ShareBikeCompany[] shareBikeCompanies) {
        System.out.println("------>4.借出Bike");
        companyOperator();
        int num = sc.nextInt();
        boolean flag = true;
        do {
            System.out.println("请输入借出单车序号：");
            int id = sc.nextInt();
            if (num > shareBikeCompanies.length || num < 0) {
                System.out.println("选项不存在，请重新输入");
            } else {
                switch (num) {
                    case 1:
                        shareBikeCompanies[0].lendBike(id);
                        break;
                    case 2:
                        shareBikeCompanies[1].lendBike(id);
                        break;
                    default:
                        shareBikeCompanies[2].lendBike(id);
                        break;
                }
                flag = false;
            }
        } while (flag);
    }

    private void returnBike(Scanner sc, ShareBikeCompany[] shareBikeCompanies) {
        System.out.println("------>5.归还Bike");
        companyOperator();
        int num = sc.nextInt();
        boolean flag = true;
        do {
            System.out.println("请输入借出单车序号：");
            int id = sc.nextInt();
            if (num > shareBikeCompanies.length || num < 0) {
                System.out.println("选项不存在，请重新输入");
            } else {
                switch (num) {
                    case 1:
                        shareBikeCompanies[0].returnBike(id);
                        break;
                    case 2:
                        shareBikeCompanies[1].returnBike(id);
                        break;
                    default:
                        shareBikeCompanies[2].returnBike(id);
                        break;
                }
                flag = false;
            }
        } while (flag);
    }

    private void rankBike(ShareBikeCompany[] shareBikeCompanies) {
        ShareBikeCompany[] shareBikeCompaniesTemp = Arrays.copyOf(shareBikeCompanies, 3);
        System.out.println("------>6.Bike排行榜");
        ShareBikeCompany shareBikeCompany;
        for (int i = 0; i < shareBikeCompaniesTemp.length - 1; i++) {
            for (int j = 0; j < shareBikeCompaniesTemp.length - 1 - i; j++) {
                if (shareBikeCompaniesTemp[j].getCount() < shareBikeCompaniesTemp[j + 1].getCount()) {
                    shareBikeCompany = shareBikeCompaniesTemp[j];
                    shareBikeCompaniesTemp[j] = shareBikeCompaniesTemp[j + 1];
                    shareBikeCompaniesTemp[j + 1] = shareBikeCompany;
                }
            }
        }
        System.out.println("| 公司名 | 单车借出次数 |");
        for (ShareBikeCompany bikeCompany : shareBikeCompaniesTemp) {
            System.out.print(bikeCompany.getBikeCompanyName() + " ");
            System.out.print(bikeCompany.getCount());
            System.out.println();
        }
    }

    private void systemExit() {
        System.out.println("------>7.退出");
        System.out.println("系统正在退出(๑•̀ㅂ•́)و✧");
        System.exit(0);
    }

    public void companyOperator() {
        System.out.println("1：ofo单车");
        System.out.println("2：halo单车");
        System.out.println("3：摩拜单车");
        System.out.println("请选择要操作的单车品牌：");
    }

}
