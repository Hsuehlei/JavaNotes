package exercise.assignment3;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/1 17:02
 */
public class Person {
    
    private int id;
    private String name;
    private int age;
    private Person p;
    
    static int count;

    public Person() {
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        Person.count++;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public Person ageCompare(Person p) {
        if (p.age > this.age) {
            System.out.println(p.name + "的年龄比" + this.name + "的年龄大了" + (p.age - this.age) + "岁");
        } else if (p.age == this.age) {
            System.out.println(p.name + "的年龄和" + this.name + "的年龄相同");
        } else {
            System.out.println(this.name + "的年龄比" + p.name + "的年龄大了" + (this.age - p.age) + "岁");
        }

        return p;
    }
}
