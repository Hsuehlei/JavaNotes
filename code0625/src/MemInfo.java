import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/24 21:59
 * @description 需求说明：录入会员信息（会员号、会员生日、会员积分）并显示录入信息
 *              升级功能：判断录入是否合法（会员号必为4位整数），
 *                       录入合法，显示录入的信息；
 *                       不合法，显示“录入失败”
 */
public class MemInfo {
    public static void main(String[] args) {

        int memberId;
        int memberBirthday;
        int memberPoints = 0;

        while (true) {
            Scanner mid = new Scanner(System.in);
            System.out.println("请输入会员号：");
            int id = mid.nextInt();
            if (id > 999 && id < 10000) {
                memberId = id;
            } else {
                System.out.println("会员号不合法，请重新输入！");
                continue;
            }

            Scanner mb = new Scanner(System.in);
            System.out.println("请输入会员生日：");
            int bd = mb.nextInt();
            if (bd > 19000101 && bd < 20200625 && (bd % 100) > 0 && (bd % 100) < 31) {
                memberBirthday = bd;
                System.out.println("您输入的会员生日为：" + memberBirthday);
            } else {
                System.out.println("会员生日不合法，请重新输入！");
                continue;
            }

            //输入小数时出现类型不匹配异常InputMismatchException???
            //原因在于变量mbp只能接收整型输入
            Scanner mp = new Scanner(System.in);
            System.out.println("请输入会员积分：");
            int mbp = mp.nextInt();
            if (mbp < 1 && mbp != 0) {
                System.out.println("录入失败，请重新输入！");
                continue;
            } else {
                memberPoints = mbp;
            }

            System.out.println("会员号为：" + memberId);
            System.out.println("会员生日为：" + memberBirthday);
            System.out.println("会员积分为：" + memberPoints);
        }
    }
}
