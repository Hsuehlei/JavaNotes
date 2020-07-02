package assignment2;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/2 16:59
 */
public class Bird extends Animal {

    private String color;

    public Bird(){

    }

    public Bird(String color) {
        this.color = color;
    }

    public Bird(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void move() {
        System.out.println("鸟类都可以移动");
    }

    public void fly() {
        System.out.println("鸟类大多数可以飞");
    }
}
