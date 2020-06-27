import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/24 21:59
 */
public class MemInfo {
    public static void main(String[] args) {

        test();
    }
    
    /**
     *  需求说明：录入会员信息（会员号、会员生日、会员积分）并显示录入信息
     *           升级功能：判断录入是否合法（会员号必为4位整数），
     *                    录入合法，显示录入的信息；
     *                    不合法，显示“录入失败”
     */
    public static void test() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的会员号：");
        int vipNum = sc.nextInt();
        //判断会员号的合法性
        if ((vipNum / 1000 > 0) && (vipNum / 1000 < 10)) {
            System.out.println("会员号为：" + vipNum);
        } else {
            System.out.println("不合法，重新输入");
            //跳出方法体
            return;
        }

        Random r = new Random();
        int randomNum = r.nextInt(10);
        System.out.println("生成的随机数是" + randomNum);
        int bai = vipNum / 100 % 10;
        if (randomNum == bai) {
            System.out.println("你的百位数是" + bai);
            System.out.println("恭喜你 中奖了");
        } else {
            System.out.println("你的百位数是" + bai);
            System.out.println("请再接再厉");
        }
    }
}
