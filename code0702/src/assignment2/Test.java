package assignment2;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/2 17:03
 */
public class Test {

    public static void main(String[] args) {

        Bird b = new Bird();
        b.setName("珍珠鸟");
        b.setAge(2);
        b.setColor("Pink");

        System.out.println("我有一只" + b.getAge() + "岁的" + b.getName());
        System.out.println("它的颜色是" + b.getColor());
        b.move();
        b.fly();
    }
}
