/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/9 19:47
 */
public class Student {

    private String name;
    private int age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }

}
