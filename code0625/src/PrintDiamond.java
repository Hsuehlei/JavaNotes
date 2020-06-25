/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/25 19:27
 * @description 打印菱形
 */
public class PrintDiamond {
    public static void main(String[] args) {

        int size=4;
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size - i; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print('*');
            }
            System.out.println();
        }
        for (int i = 1; i <= size-1; i++) {
            for (int j = 1; j <= i; j++){
                System.out.print(" ");
            }

            for (int k = 2*size-3; k >= 2 * i - 1; k--){
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
