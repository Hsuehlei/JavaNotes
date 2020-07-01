package exercise.assignment1;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/1 15:13
 */
public class PM {

    private int id;
    private String name;
    private char gender;
    private double salary;
    private String exp;
    private double bonus;

    public PM() {
        this.id = 1000;
        this.name = "张三";
        this.gender = '男';
        this.salary = 10000.0;
        //项目分红
        this.exp = "3个项目";
        //项目经验
        this.bonus = 50000;
    }

    public PM(int id, String name, char gender, double salary, String exp, double bonus) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.exp = exp;
        this.bonus = bonus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void show() {
        System.out.println("项目经理详细信息：");
        System.out.println("编号\t\t"+ id);
        System.out.println("姓名\t\t"+name);
        System.out.println("性别\t\t"+gender);
        System.out.println("工资\t\t"+salary);
        System.out.println("项目经验\t\t"+exp);
        System.out.println("项目分红\t\t"+bonus);
        System.out.println("----------");

    }

}
