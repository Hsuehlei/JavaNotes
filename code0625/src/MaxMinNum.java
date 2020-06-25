import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/25 17:35
 * @description 请使用条件结构/三元运算符求3个数的最值
 */
public class MaxMinNum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第1个数：");
        int first = sc.nextInt();
        System.out.println("请输入第2个数：");
        int second = sc.nextInt();
        System.out.println("请输入第3个数：");
        int third = sc.nextInt();

        if (first > second) {
            int max = first > third ? first : third;
            System.out.println("最大值是" + max);
            if (second > third) {
                System.out.println("最小值是" + third);
            } else {
                System.out.println("最小值是" + second);
            }
        } else {
            int max = second > third ? second : third;
            System.out.println("最大值是" + max);
            if (first > third) {
                System.out.println("最小值是" + third);
            } else {
                System.out.println("最小值是" + first);
            }
        }

    }
}
