package assignment4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/16 14:55
 */
public class Login {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName = sc.next();
        System.out.println("请输入密码");
        String passWord = sc.next();

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("./resources/login.properties")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (userName.equals(properties.getProperty("userName")) &&
                passWord.equals(properties.getProperty("passWord"))) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

    }
}
