package assignment;

import java.util.Arrays;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/8 17:15
 */
public class Task5 {

    public static void main(String[] args) {

        int[] arr = {1,2,3};
        StringBuffer str = new StringBuffer();
        str.append("[");
        for (int i = 0; i < arr.length; i++) {
            str.append(arr[i]);
            if (i<2) {
                str.append(",");
            }
        }
        str.append("]");

        System.out.println(str);
    }
}
