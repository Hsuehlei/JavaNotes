package assignment3;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/2 17:12
 */
public class BMW extends Car {

    private int panoramicSkylight;

    public BMW() {
    }

    public BMW(int panoramicSkylight) {
        this.panoramicSkylight = panoramicSkylight;
    }

    public BMW(String color, String name, int age, int panoramicSkylight) {
        super(color, name, age);
        this.panoramicSkylight = panoramicSkylight;
    }

    public int getPanoramicSkylight() {
        return panoramicSkylight;
    }

    public void setPanoramicSkylight(int panoramicSkylight) {
        this.panoramicSkylight = panoramicSkylight;
    }

    public void unmanned() {
        System.out.println("我有无人驾驶");
    }
}
