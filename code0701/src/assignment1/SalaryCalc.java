package exercise.assignment1;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/1 16:39
 */
public class SalaryCalc {

    private SE se;
    private PM pm;

    public SalaryCalc() {
    }

    public SalaryCalc(SE se, PM pm) {
        this.se = se;
        this.pm = pm;
    }

    public SE getSe() {
        return se;
    }

    public void setSe(SE se) {
        this.se = se;
    }

    public PM getPm() {
        return pm;
    }

    public void setPm(PM pm) {
        this.pm = pm;
    }

    public SE pay(SE se) {
        double salary = se.getSalary() * 0.8;
        se.setSalary(salary);
        return se;
    }

    public PM pay(PM pm) {
        double salary = pm.getSalary() * 0.8 + pm.getBonus();
        pm.setSalary(salary);
        return pm;
    }
}
