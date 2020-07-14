package assignment1;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/13 20:00
 */
public abstract class Employee {

    public Integer id;
    public String name;
    public Double salary;


    /**
     * show方法
     */
    public String show() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary;
    }

    public Employee(Integer id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    /**
     * set方法等用到的时候再添加
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }
}
