/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/25 19:12
 * @description 打印三角形
 */
public class PrintTriangle {
    public static void main(String[] args) {

        for(int i=1;i<=4;i++){

            for(int j=3; i<=j; j--) {
                System.out.print(" ");
            }

            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }

            for(int j=1; j<i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
