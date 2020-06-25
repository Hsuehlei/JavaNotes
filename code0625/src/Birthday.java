import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/25 20:00
 * @description 购物管理系统生日问候
 *              请输入今天的日期（月/日<用两位数表示：）：05/29
 *              请输入客户生日：08/09
 *              然后判断是否今天生日
 *              是否继续（y/n)
 *              如果是y就重复以上步骤，否则退出程序
 *              字符串判断相等："05/29".equals(birthday);
 */
public class Birthday {
    public static void main(String[] args) {

        while (true) {

            Scanner sc = new Scanner(System.in);
            System.out.println("请输入今天的日期（月/日<用两位数表示：05/29）：");
            String todayDate = sc.next();

            System.out.println("请输入客户生日（08/09）：");
            String clientBirthday = sc.next();

            if (todayDate.equals(clientBirthday)) {
                System.out.println("今天是客户生日");
            } else {
                System.out.println("今天不是客户的生日");
            }

            System.out.println("是否继续？");
            String x = sc.next();
            if (x.equals("y")) {
                continue;
            } else {
                break;
            }
        }
    }
}
