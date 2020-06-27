/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/25 19:27
 * @description 打印菱形
 */
public class PrintDiamond {
    public static void main(String[] args) {

        //打印菱形分两段
        int rowNumUp = 5;
        //上五行
        for (int i = 1; i <= rowNumUp; i++) {

            for (int j = 1; j <= rowNumUp - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //下四行
        int rowNumDown = 4;
        for (int i = 1; i <=rowNumDown; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2*(4 - i + 1)-1) ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
