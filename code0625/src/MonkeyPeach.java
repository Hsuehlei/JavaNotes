/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/25 17:55
 * @description 猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾，又多吃了一个。
 *              以后每天早上都吃了前一天剩下的一半零一个。
 *              到第十天早上想再吃时，见只剩一个桃子了。求第一天共摘了多少？
 */
public class MonkeyPeach {
    public static void main(String[] args) {

        int peachNum = 1;
        int day = 1;
        while (day <= 10) {
            peachNum = (peachNum + 1) * 2;
            day++;
        }
        System.out.println("第一天一共摘了" + peachNum +"个桃子");
    }
}
