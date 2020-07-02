package assignment1;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/2 16:49
 */
public class LuckyCat {

    private String jacketStyle;

    public LuckyCat(String jacketStyle) {
        this.jacketStyle = jacketStyle;
    }

    public String getJacketStyle() {
        return jacketStyle;
    }

    public void setJacketStyle(String jacketStyle) {
        this.jacketStyle = jacketStyle;
    }

    public void fly() {
        System.out.println("我能在天上飞");
    }
}
