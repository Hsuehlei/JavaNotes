package assignment;

import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/9 17:18
 */
public class Task2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str1 = sc.next();
        StringBuffer sb = new StringBuffer(str1);
        sb.reverse();
        String str2 = sb.toString();
        if (str2.equals(str1)) {
            System.out.println("是回文字符串");
        } else {
            System.out.println("不是回文字符串");

        }

    }
}
