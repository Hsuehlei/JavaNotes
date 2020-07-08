package assignment;

import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/8 17:05
 */
public class Task4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入盘符：");
        String i = scanner.next();
        System.out.println("请输入文件路径：");
        String j = scanner.next();
        System.out.println("请输入文件名：");
        String k = scanner.next();
        System.out.println("请输入文件类型：");
        String l = scanner.next();

        StringBuffer sb = new StringBuffer();
        sb.append(i);
        sb.append("\\");
        sb.append(j);
        sb.append(k);
        sb.append(".");
        sb.append(l);
        System.out.println(sb);
    }
}
