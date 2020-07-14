package assignment2;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/13 20:00
 */
public abstract class Employee {

    public int id;
    public String name;
    public int age;

    /**
     * show方法
     */
    public abstract void show();

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
