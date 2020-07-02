package assignment3;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/2 17:10
 */
public class Car {

    private String color;
    private String name;
    private int tire;

    public Car() {
    }

    public Car(String color, String name, int age) {
        this.color = color;
        this.name = name;
        this.tire = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTire() {
        return tire;
    }

    public void setTire(int tire) {
        this.tire = tire;
    }

    public void run() {
        System.out.println("车子都能跑");
    }
}
