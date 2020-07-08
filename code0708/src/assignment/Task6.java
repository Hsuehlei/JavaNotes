package assignment;

import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/8 17:25
 */
public class Task6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("输入字符串：");
        String str = sc.next();
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        sb.reverse();
        System.out.println(sb);
    }
}
