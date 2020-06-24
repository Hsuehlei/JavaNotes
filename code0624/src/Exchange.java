/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/24 19:25
 * @description 变量a和b的值互换
 *              例如：int a = 10,b=20;
 *              结果：a=20,b=10;
 */
public class Exchange {
    public static void main(String[] args) {

        int a = 22;
        int b = 33;
        int temp;

        System.out.println("交换之前a=" + a + "，B=" + b);

        temp = a;
        a = b;
        b = temp;

        System.out.println("交换之后a=" + a + "，B=" + b);
    }
}
