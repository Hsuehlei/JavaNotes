import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/25 20:16
 * @description 从键盘接收一个整数N，统计出1~N之间能被7整除的整数的个数，以及这些能被7整除的数的和。
 */
public class Keyboard {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int n = sc.nextInt();
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 7 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        System.out.println("能被7整除的数的和：" + sum);
    }
}
