package assignment1;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/2 16:47
 */
public class SnivelPig extends Pet {

    private String hairColor;

    public SnivelPig(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public void roll() {
        System.out.println("我能在地上打滚");
    }
}
