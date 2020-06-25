/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/25 19:34
 * @description 循环输出数字乘法
 */
public class NumMulti {
    public static void main(String[] args) {

        int i = 2;
        int j = 5;

        do {
            System.out.println(i + "*" + j + "=" + i*j);
            i += 2;
            j += 5;
        } while (j <= 100);
    }
}
