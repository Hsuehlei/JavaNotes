package assignment;

import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/7 12:42
 */
public class Assignment3 {

    public static void main(String[] args) {

        int[] goodsList = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("请输入商品号：");

        try {
            demo(goodsList);
        } catch (NullGoodsException nge) {
            System.out.println(nge.getMessage());
        }

    }

    public static void demo(int[] goodsList) throws NullGoodsException {
        Scanner sc = new Scanner(System.in);
        int goodsId = sc.nextInt();
        if (goodsId<=0 || goodsId > goodsList.length) {
            throw new NullGoodsException("抱歉，该商品不存在。");
        } else {
            for (int value : goodsList) {
                if (goodsId == value) {
                    System.out.println("您选择的商品是:" + goodsId + "号，");
                    System.out.println("祝您购物愉快！");
                    return;
                }
            }
        }
    }
}
