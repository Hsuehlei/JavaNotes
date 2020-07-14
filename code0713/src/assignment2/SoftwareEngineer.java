package assignment2;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/13 20:05
 */
public class SoftwareEngineer extends Employee{

    double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public SoftwareEngineer(int id, String name, int age, double salary) {
        super(id, name, age);
        this.salary = salary;
    }

    @Override
    public void show() {
        System.out.println("Programmer");
    }
}
