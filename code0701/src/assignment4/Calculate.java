package exercise.assignment4;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/1 17:13
 */
public class Calculate {

    private double operand1;
    private double operand2;
    private String operator;
    Calculate cal;

    public Calculate() {
    }

    public Calculate(int operand1, int operand2, String operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    public double getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Calculate calc(Calculate cal) {
        if ("+".equals(cal.operator)) {
            System.out.println(cal.operand1 + " + " + cal.operand2 + " = " + (cal.operand1 + cal.operand2));
        } else if ("-".equals(cal.operator)) {
            System.out.println(cal.operand1 + " - " + cal.operand2 + " = " + (cal.operand1 - cal.operand2));
        } else if ("*".equals(cal.operator)) {
            System.out.println(cal.operand1 + " * " + cal.operand2 + " = " + (cal.operand1 * cal.operand2));
        } else if ("/".equals(cal.operator)) {
            System.out.println(cal.operand1 + " / " + cal.operand2 + " = " + (cal.operand1 / cal.operand2));
        } else {
            System.out.println("不能识别运算符");
        }
        return cal;
    }
}
