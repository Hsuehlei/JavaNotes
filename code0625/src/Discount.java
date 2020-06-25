import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/25 17:19
 * @description 会员根据积分享受不同折扣，使用多重if结构计算会员折扣
 */
public class Discount {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入会员积分数：");
        int points = sc.nextInt();
        if (points >= 8000) {
            System.out.println("打6折");
        } else if (points >= 4000 && points < 8000) {
            System.out.println("打7折");
        } else if (points >= 2000 && points < 4000) {
            System.out.println("打8折");
        } else {
            System.out.println("打9折");
        }

    }
}
