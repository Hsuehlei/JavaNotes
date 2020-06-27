import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/25 17:22
 * @description 要求用户输入两个数a、b，如果a能被b整除或a加b大于1000，则输出a，否则输出b
 */
public class TwoNum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请用户输入第一个数a：");
        int a = sc.nextInt();
        System.out.println("请用户输入第二个数b：");
        int b = sc.nextInt();

        System.out.println("----------");
        if (a % b == 0 || a + b > 1000) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
        sc.close();
    }
}
