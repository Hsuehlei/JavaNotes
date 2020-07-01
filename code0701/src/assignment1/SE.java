package exercise.assignment1;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/1 15:13
 */
public class SE {

    private int id;
    private String name;
    private char gender;
    private double salary;
    private int hot;

    public SE() {
        this.id = 1000;
        this.name = "张大仙";
        this.gender = '男';
        this.salary = 8000.0;
        this.hot = 0;
    }

    public SE(int id, String name, char gender, double salary, int hot) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.hot = hot;
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

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public void show() {
        System.out.println("程序员详细信息：");
        System.out.println("编号\t\t"+ id);
        System.out.println("姓名\t\t"+name);
        System.out.println("性别\t\t"+gender);
        System.out.println("工资\t\t"+salary);
        System.out.println("关注度\t\t"+hot);
        System.out.println("----------");
    }
}
