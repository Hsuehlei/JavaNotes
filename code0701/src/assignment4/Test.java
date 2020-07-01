package exercise.assignment4;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/1 17:24
 */
public class Test {

    public static void main(String[] args) {

        Calculate cal = new Calculate();
        cal.setOperand1(10);
        cal.setOperand2(20);
        cal.setOperator("*");
        cal.calc(cal);

        Calculate cal1 = new Calculate(15,18,"/");
        cal.calc(cal1);
    }
}
