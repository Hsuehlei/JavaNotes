package assignment1;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/13 20:05
 */
public class SoftwareEngineer extends Employee {

    private int id;

    public SoftwareEngineer() {
    }

    public SoftwareEngineer(String name, int age, int id) {
        super(name, age);
        this.id = id;
    }

    @Override
    public void show() {
        System.out.println("Programmer");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age;
    }
}
