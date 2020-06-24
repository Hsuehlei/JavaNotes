/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/24 19:01
 * @description 自己给定5个整数，通过编程求出最大值(使用三元运算符)
 */
public class Max {
    public static void main(String[] args) {
        int a = 1;
        int b = 7;
        int c = 3;
        int d = 11;
        int e = 9;

        int x = a>b?a:b;
        x = x>c?x:c;
        x = x>d?x:d;
        x = x>e?x:e;

        System.out.println("五个数的最大值为" + x);

    }
}
