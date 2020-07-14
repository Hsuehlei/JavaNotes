package assignment1;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/13 20:11
 */
public class ProjectManager extends Employee {

    private Double allowance;

    public ProjectManager(Integer id, String name, Double salary, Double allowance) {
        super(id, name, salary);
        this.allowance = allowance;
    }

    public Double getAllowance() {
        return allowance;
    }

    @Override
    public String show() {
        return super.show() + ",allowance=" + allowance;
    }


}
