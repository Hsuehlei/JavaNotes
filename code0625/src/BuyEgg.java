import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/25 17:21
 * @description 小林子买了一筐鸡蛋，如果坏蛋少于5个，他就吃掉，否则他就去退货
 */
public class BuyEgg {
    public static void main(String[] args) {

        Scanner sc4 = new Scanner(System.in);
        System.out.println("请输入坏鸡蛋的数量：");
        int number = sc4.nextInt();
        if (number < 5) {
            System.out.println("他就吃掉");
        } else {
            System.out.println("他就退货");
        }

    }
}
