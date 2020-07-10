package assignment;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/10 16:32
 */
public class Task3 {

    public static void main(String[] args) {

        String str = "qazxswecdfrvtgbnhyujmkilop123456789+-*";
        char[] ch = str.toCharArray();
        char[] password = new char[6];
        Random r = new Random();

        for (int i = 0; i < 6; i++) {
            int x = r.nextInt(38);
            if (str.indexOf(x) != ' ') {
                password[i] = ch[x];
                str.replace(str.charAt(x),' ');
                continue;
            }
            i--;
        }

        System.out.println(Arrays.toString(password));
    }
}
