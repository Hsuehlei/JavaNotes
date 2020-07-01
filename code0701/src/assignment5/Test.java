package exercise.assignment5;

import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/1 17:46
 */
public class Test {

    public static void main(String[] args) {

        Admin ad = new Admin("张三","123456");
        Admin ad1 = new Admin();

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String userName = sc.next();
        ad1.setUserName(userName);
        System.out.print("请输入密码：");
        String passWord = sc.next();
        ad1.setPassWord(passWord);

        ad.check(ad1);
    }
}
