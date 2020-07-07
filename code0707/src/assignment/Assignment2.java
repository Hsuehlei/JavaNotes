package assignment;

import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/7 11:36
 */
public class Assignment2 {

    public static void main(String[] args) throws NullGoodsException {

        int[] goodsList = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入商品号：");

        int goodsId = sc.nextInt();

        if (goodsId <= 0 || goodsId > 9) {
            throw new NullGoodsException("抱歉，该商品不存在。");
        } else {
            for (int i = 0; i < goodsList.length; i++) {

                if (goodsList[i] == goodsId) {
                    System.out.println("您选择的商品是:" + (i+1) + "号，");
                    System.out.println("祝您购物愉快！");
                    break;
                }

            }
        }
    }
}
