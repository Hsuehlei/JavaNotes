package assignment1;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/2 16:51
 */
public class DoudouCattle {

    private String hornShape;

    public DoudouCattle(String hornShape) {
        this.hornShape = hornShape;
    }

    public String getHornShape() {
        return hornShape;
    }

    public void setHornShape(String hornShape) {
        this.hornShape = hornShape;
    }

    public void pickUpProps() {
        System.out.println("我能捡掉落的道具🗡");
    }
}
