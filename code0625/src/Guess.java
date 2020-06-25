import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/25 19:01
 * @description 要求用户输入一个0到2之间的整数
 *              如果用户输入0输出“你出的是石头”，
 *              如果用户输入1就输出“你出的是剪刀”，
 *              如果用户输入的是2就输出“你出的是布”，
 *              然后再问是否要继续出拳，
 *              如果回答“y”就重复以上过程，
 *              否则结束程序
 */
public class Guess {
    public static void main(String[] args) {

        while (true) {

            Scanner sc = new Scanner(System.in);
            System.out.println("请输入一个0到2之间的整数");
            int input = sc.nextInt();

            if (input >= 0 && input <= 2) {
                switch (input) {
                    case 0:
                        System.out.println("你出的是石头");
                        break;
                    case 1:
                        System.out.println("你出的是剪刀");
                        break;
                    default:
                        System.out.println("你出的是布");
                }
            } else {
                System.out.println("输入不合法，请重新输入！");
            }

            System.out.println("请问是否要继续出拳？");
            String x = sc.next();

            if (x.equals("y")) {
                continue;
            } else {
                break;
            }

        }

    }
}
