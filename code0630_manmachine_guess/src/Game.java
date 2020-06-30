import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/30 14:26
 */
public class Game {

    String robot;
    int scoreRobot;
    int scoreMen;
    String gamerName;
    int fightCounts;

    public void initial() {

        String liuBei = "刘备";
        String sunQuan = "孙权";
        String caoCao = "曹操";

        System.out.println("*******************");
        System.out.println("**    猜拳,开始   **");
        System.out.println("*******************");

        Scanner sc = new Scanner(System.in);
        System.out.println("出拳规则：1.剪刀2.石头3.布");
        System.out.print("请选择对方角色（1.刘备；2.孙权；3.曹操）：");
        boolean flag = true;
        while (flag) {
            if (sc.hasNextInt()) {
                switch (sc.nextInt()) {
                    case 1:
                        System.out.println("您选择了" + liuBei + "对战");
                        flag = false;
                        robot = liuBei;
                        break;
                    case 2:
                        System.out.println("您选择了" + sunQuan + "对战");
                        flag = false;
                        robot = sunQuan;
                        break;
                    case 3:
                        System.out.println("您选择了" + caoCao + "对战");
                        flag = false;
                        robot = caoCao;
                        break;
                    default:
                        System.out.println("抱歉，该人物暂时还未上线！");
                        System.out.print("请重新选择：");
                }
            }
        }

    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);
        //此处逻辑需要重新捋一捋
//        System.out.println("要开始吗？（y/n）");
        while (true) {
            System.out.println("要开始吗？（y/n）");
            String str1 = sc.next();
            if ("y".equalsIgnoreCase(str1)) {
                User u = new User();
                Computer com = new Computer();

                System.out.println("请出拳：1.剪刀2.石头3.布（输入相应数字）：");
                if (sc.hasNextInt()) {
                    int menFist = sc.nextInt();
                    u.showFist(menFist);
                    com.showFist();

                    fightCounts++;

                    if (menFist == com.flag) {
                        System.out.println("结果：和局，真衰！嘿嘿，等着瞧吧！");
                    } else if (com.flag > menFist || ((com.flag == 1) && (menFist == 3))) {
                        System.out.println("结果：" + robot + "赢了，再接再厉！");
                        scoreRobot++;
                    } else {
                        System.out.println("结果：恭喜，你赢了！");
                        scoreMen++;
                    }
                } else {
                    System.out.println("你的输入有误，请重新输入！");
                }
            } else if ("n".equalsIgnoreCase(str1)) {
                System.out.println("再见，下次继续！");
                break;
            } else {
                System.out.println("您的输入有误，请重新输入！");
            }

            System.out.println("是否开始下一轮（y/n）：");
            String str2 = sc.next();
            while (true) {
                if ("y".equalsIgnoreCase(str2)) {
                    System.out.println();
                    break;
                } else if ("n".equalsIgnoreCase(str2)){
                    System.out.println("请输入你的昵称：");
                    gamerName = sc.next();
                    System.out.println("------------------");
                    System.out.println(robot + "\tVS\t" + gamerName);
                    System.out.println("对战次数：" + fightCounts);
                    System.out.println("姓名\t\t得分");
                    System.out.println(robot + "\t\t" + scoreRobot);
                    System.out.println(gamerName + "\t\t" + scoreMen);
                    if (scoreMen > scoreRobot) {
                        System.out.println("结果：你赢了，恭喜恭喜！");
                    } else if (scoreMen == scoreRobot) {
                        System.out.println("结果：平局，下次继续！");
                    } else {
                        System.out.println("结果：你输了，再接再厉！");
                    }
                    System.out.println("------------------");
                    System.out.println();
                    System.out.println("系统退出");
                    break;
                } else {
                    System.out.println("您的输入有误，请重新输入！");
                }
            }
        }
    }
}
