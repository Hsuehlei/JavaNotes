package assignment1;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/13 20:11
 */
public class ProjectManager extends Employee {

    private char gender;

    public ProjectManager() {
    }

    public ProjectManager(String name, int age, char gender) {
        super(name, age);
        this.gender = gender;
    }

    @Override
    public void show() {
        System.out.println("ProjectManager");
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return  "gender=" + gender +
                ", name='" + name + '\'' +
                ", age=" + age;
    }
}
