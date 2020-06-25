import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/25 16:59
 * @description 商场实行新的抽奖规则：会员号的百位数字等于产生的随机数字即为幸运会员。
 *              实现： 1、从键盘接收4位数会员号
 *                    2、生成随机数 int random = (int) (Math.random() * 10);
 *                    3、算出会员号中在百位的数字号码 int baiwei = custNo / 100 % 10;
 *                    4、使用if-else实现幸运抽奖
 */
public class Lottery {
    public static void main(String[] args) {

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入会员号：");
            int custNo = sc.nextInt();

            int random = (int) (Math.random() * 10);
            int baiwei = custNo / 100 % 10;

            if (custNo > 999 && custNo < 10000) {
                System.out.println("今天的幸运数字是" + random);
                if (baiwei == random) {
                    System.out.println("恭喜您成为幸运会员");
                } else {
                    System.out.println("很遗憾，您没有中奖");
                }
            } else {
                System.out.println("会员号不合法，请重新输入");
            }
        }
    }
}
