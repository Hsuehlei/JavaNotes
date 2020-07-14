package assignment1;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/13 20:00
 */
public abstract class Employee {

    public String name;
    public int age;

    /**
     * show方法
     */
    public abstract void show();

    public Employee() {
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
