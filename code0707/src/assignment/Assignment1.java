package assignment;

import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/7 11:27
 */
public class Assignment1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入除数：");
        try {
            System.out.println(1 / sc.nextInt());
        } catch (ArithmeticException ae) {
            System.out.println("异常已经抛出了");
            ae.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
