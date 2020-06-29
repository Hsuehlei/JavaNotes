/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/29 14:53
 * @description 指的是这样一个数列：1、1、2、3、5、8、13、21、34、……在数学上，
 *              斐波那契数列以如下被以递推的方法定义：
 *              F(1)=1，F(2)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 3，n ∈ N*）
 */
public class Fibonacci {

    public static void main(String[] args) {

        for (long i = 0; i >= 0; i++) {
            long x = fibonacci(i);
            System.out.println(x);
        }
    }

    /**
     * 递归的源头一定要有值
     */
    private static long fibonacci(long i) {
        if (i<0) {
            return 0;
        } else if(i==1||i==2) {
            return 1;
        } else {
            return fibonacci(i-1) + fibonacci(i-2);
        }
    }
}
