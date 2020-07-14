package assignment2;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/13 20:11
 */
public class ProjectManager extends Employee {

    private char gender;

    public ProjectManager(int id, String name, int age, char gender) {
        super(id, name, age);
        this.gender = gender;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public void show() {
        System.out.println("ProjectManager");
    }
}
