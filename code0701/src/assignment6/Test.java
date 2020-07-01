package exercise.assignment6;

import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/1 19:20
 */
public class Test {
    public static void main(String[] args) {
        Vip v = new Vip();
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你的会员号：");
        int vipId = sc.nextInt();
        v.setVipId(vipId);
        System.out.print("请输入你的会员姓名：");
        String vipName = sc.next();
        v.setVipName(vipName);
        System.out.print("请输入你的会员积分：");
        int score = sc.nextInt();
        v.setScore(score);
        v.check(v);

    }
}
