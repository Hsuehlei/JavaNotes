/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/25 20:08
 * @description 打印出所有的 "水仙花数"
 *              所谓 "水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
 *              例如：153是一个 "水仙花数 "，因为153=1的三次方＋5的三次方＋3的三次方。
 */
public class DaffodilNumber {
    public static void main(String[] args) {

        for (int i = 100; i < 1000; i++) {
            int first = i / 100;
            int second = i / 10 % 10;
            int third = i % 10;

            int x = (int) (Math.pow(first, 3) + Math.pow(second, 3) + Math.pow(third, 3));

            if (i == x) {
                System.out.println(i);
            } else {
                continue;
            }
        }
    }
}
