package assignment;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/10 20:10
 */
public class Task7 {

    public static void main(String[] args) {

        char[] ch = RandomUtil.utils(10);
        System.out.println(Arrays.toString(ch));
    }
}

class RandomUtil {
    public static char[] utils(int n) {
        String str = "qazxswecdfrvtgbnhyujmkilopABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+-*";
        char[] ch = str.toCharArray();
        char[] password = new char[n];
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            int x = r.nextInt(65);
            if (str.indexOf(x) != ' ') {
                password[i] = ch[x];
                str.replace(str.charAt(x),' ');
                continue;
            }
            i--;
        }

        return password;
    }
}
