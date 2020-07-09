package assignment;

import java.util.Arrays;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/9 19:15
 */
public class Task11 {

    public static void main(String[] args) {

        String a = "hello.java,a.txt,x1.jpg,t1.ppt,m.jpg";
        //以，分割
        String[] as = a.split(",");
        System.out.println(Arrays.toString(as));
        for (String s : as) {
            if (s.endsWith(".jpg")) {
                System.out.println(s);
            }
        }
    }
}
