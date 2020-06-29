import java.util.Random;
import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/26 20:40
 * @update 2020/6/29 18:22
 * @description 任务:模拟注册登录幸运抽奖全过程
 *              主要功能:注册、登录、幸运抽奖
 */
public class LuckDraw {

    private static String userName;
    private static String password;
    private static int errorCount = 3;
    private static boolean luckyFlag;
    private static boolean registerFlag;
    private static boolean loginFlag;

    /*
     * 也可以用数组存储用户的注册信息，用户名，密码，会员卡号
     * String[] arr = new String[3];
     */

    public static void main(String[] args) {

        while (true) {
            System.out.println("*****欢迎进入幸运富翁系统*****");
            System.out.println("          1.注册");
            System.out.println("          2.登录");
            System.out.println("          3.抽奖");
            System.out.println("****************************");

            System.out.print("请选择菜单：");
            Scanner sc = new Scanner(System.in);
            int num;
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                switch (num) {
                    case 1:
                        register(sc);
                        exit(sc);
                        break;
                    case 2:
                        login(sc);
                        exit(sc);
                        break;
                    case 3:
                        lottery(sc);
                        exit(sc);
                        break;
                    default:
                        System.out.println("系统君不能理解，请重新输入！");
                        System.out.println();
                }
            } else {
                System.out.println("您的输入有误，请重新输入！");
                System.out.println();
            }
        }
    }

    /**
     * 系统继续和退出
     */
    private static void exit(Scanner sc) {
        System.out.println("继续吗？（y/n）：");
        String judge = sc.next();
        if ("y".equalsIgnoreCase(judge)) {
            System.out.println();
        } else if ("n".equalsIgnoreCase(judge)) {
            System.out.println("系统退出，谢谢使用！");
            System.exit(0);
        } else {
            System.out.println("您的输入有误！");
        }
    }

    /**
     * 需求说明：1.输入用户名和密码，系统产生 4位随机数作为卡号。
     *          2.注册成功，显示注册信息并修改注册标识为true
     */
    private static void register(Scanner sc) {
        System.out.println("[幸运富翁系统 > 注册]");
        System.out.println("请填写个人注册信息：");
        System.out.print("用户名：");
        userName = sc.next();
        System.out.print("密码：");
        password = sc.next();

        Random r = new Random();
        //random产生的随机数不包含上限
        int vipNum = r.nextInt(9999 - 1000 + 1) + 1000;

        registerFlag = true;

        System.out.println("注册成功，请记好您的会员卡号");
        System.out.println("用户名\t\t密码\t\t会员卡号");
        System.out.println(userName + "  \t\t" + password + "\t\t" + vipNum);
    }

    /**
     * 需求说明：1.输入注册时的用户名和密码，登录成功，系统提示欢迎信息
     *          2.如果用户名和密码输入错误，提示用户继续输入，最多有3 次输入机会
     */
    private static void login(Scanner sc) {
        if (registerFlag) {
            System.out.println("[幸运富翁系统 > 登录]");
            System.out.print("请输入用户名：");
            String loginUserName = sc.next();
            System.out.print("请输入密码：");
            String loginPassword = sc.next();

            if (loginUserName.equals(userName) && (loginPassword.equals(password))) {
                System.out.println();
                System.out.println("欢迎您：" + loginUserName);
                loginFlag = true;
            } else {
                System.out.println();
                System.out.println("用户名或密码错误！");
                if (errorCount > 0) {
                    System.out.println("请重新输入！");
                    System.out.println("您还有" + errorCount + "次输入机会！");
                    System.out.println();
                    errorCount--;
                } else {
                    System.out.println("您没有机会了哦!");
                    //强制退出Java虚拟机
                    System.exit(0);
                }
            }
        } else {
            System.out.println("您还没有注册，请先注册！");
            System.out.println();
        }
    }

    /**
     * 需求说明：1.登录成功后，用户选择幸运抽奖菜单，进入幸运抽奖功能
     *          2.输入会员卡号，系统生成5个4位随机数作为幸运数字
     *          3.如果会员卡号是其中之一，则成为本日幸运会员；否则不是幸运会员
     */
    private static void lottery(Scanner sc) {
        System.out.println("[幸运富翁系统 > 抽奖]");
        if (loginFlag) {
            System.out.print("请输入您的卡号：");
            int vipId = sc.nextInt();
            System.out.println();

            Random r = new Random();
            int[] arr = new int[5];

            for (int i = 0; i < 5; i++) {
                //可以用一个整型变量直接接收生成的随机数
                //然后直接与会员号vipID校验
                //此处选择用数组存放生成的随机数
                arr[i] = r.nextInt(9999 - 1000 + 1) + 1000;
            }

            System.out.print("本日的幸运数字为：");
            for (int i = 0; i < 5; i++) {
                System.out.print(arr[i] + "\t");
            }

            System.out.println();

            for (int x : arr) {
                if (vipId == x) {
                    luckyFlag = true;
                    break;
                } else {
                    luckyFlag = false;
                }
            }

            if (luckyFlag) {
                System.out.println("恭喜您！您是今日的幸运会员！");
            } else {
                System.out.println("抱歉！您不是本日的幸运会员！");
            }
        } else {
            System.out.println("您还没有登录，请先登录！");
            System.out.println();
        }
    }
}
