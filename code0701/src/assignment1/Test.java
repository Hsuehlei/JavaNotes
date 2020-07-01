package exercise.assignment1;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/1 16:29
 */
public class Test {

    public static void main(String[] args) {

        SE se = new SE();
        se.show();
        SE se1 = new SE(1001,"白小天",'女',9000.0,23);
        se1.show();

        PM pm = new PM();
        pm.show();
        PM pm1 = new PM(10005,"王富贵",'男',10500.0,"5个项目",80000.0);
        pm1.show();

        System.out.println("**************");

        SalaryCalc sc = new SalaryCalc();
        sc.pay(se1);
        se1.show();
        sc.pay(pm1);
        pm1.show();
    }
}
