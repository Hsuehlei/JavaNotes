package assignment3;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/2 17:16
 */
public class Benz extends Car {

    /**
     * 自动巡航
     */
    private int autoCruise;

    public Benz() {
    }

    public Benz(int autoCruise) {
        this.autoCruise = autoCruise;
    }

    public Benz(String color, String name, int age, int autoCruise) {
        super(color, name, age);
        this.autoCruise = autoCruise;
    }

    public int getAutoCruise() {
        return autoCruise;
    }

    public void setAutoCruise(int autoCruise) {
        this.autoCruise = autoCruise;
    }

    public void turbo() {
        System.out.println("我有涡轮增压");
    }
}
