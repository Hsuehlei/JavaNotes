/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/25 19:12
 * @description 打印等腰三角形
 */
public class PrintTriangle {
    public static void main(String[] args) {

        int rowNum = 4;
        for (int i = 1; i <= rowNum; i++) {
            //打印空格和打印星号都是循环再做
            //打印空格
            for (int j = 1; j <= rowNum - i; j++) {
                System.out.print(" ");
            }

            //打印星号
            for (int j = 1; j <= (i * 2 - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
