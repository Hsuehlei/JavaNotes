package assignment;

import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/8 17:41
 */
public class Task10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        boolean flag = true;
        while (flag) {
            System.out.println("请输入英文字母：");
            String str = sc.next();
            sb.append(str);
            if (sb.length()>=6) {
                flag = false;
            }
        }

        int x = count(sb);
        System.out.println(x);
    }

    public static int count(StringBuffer str) {
        String original = str.toString();

        int i = 0;
        boolean flag = true;
        while (flag) {
            int x = original.indexOf("a");
            if (x>=0) {
                i++;
                original = original.substring(x+1);
            }
            if (x==-1) {
                flag = false;
            }
        }
        return i;
    }
}
