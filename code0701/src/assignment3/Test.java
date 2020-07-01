package exercise.assignment3;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/1 17:05
 */
public class Test {

    public static void main(String[] args) {

        Person p = new Person(10001,"张三",22);
        Person p1 = new Person(10002,"李四",25);
        p.ageCompare(p1);
        System.out.println(Person.count);
    }
}
