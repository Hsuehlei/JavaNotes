/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/25 19:39
 * @description 输出乘法口诀表
 */
public class MultiTable {
    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "X" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }
}
