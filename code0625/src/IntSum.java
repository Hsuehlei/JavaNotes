/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/25 17:47
 * @description 求1到100之间所有能被3整除的整数的和
 */
public class IntSum {
    public static void main(String[] args) {

        int sum = 0;
        int i = 1;

        while (i < 100) {
            if (i % 3 == 0) {
                sum += i;
            }
            i++;
        }

        System.out.println("1到100之间所有能被3整除的整数的和为" + sum);
    }
}
