/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/24 19:28
 * @description 定义一个变量，是一个三位数，求各个位数的和
 *              如：123，结果是1+2+3=6
 */
public class Sum {
    public static void main(String[] args) {
        int a = 999;

        int first = a / 100;
        int second = (a - first * 100) / 10;
        int third = a - first * 100 - second * 10;
        int sum = first + second + third;
        System.out.println("三位数各个位数的和为" + sum);
    }
}
