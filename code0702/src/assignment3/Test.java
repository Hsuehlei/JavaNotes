package assignment3;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/2 17:19
 */
public class Test {

    public static void main(String[] args) {

        BMW bmw = new BMW();
        bmw.setName("宝马BMW");
        bmw.setTire(4);
        bmw.setColor("Silver");
        bmw.setPanoramicSkylight(1);

        bmw.run();
        bmw.unmanned();
    }
}
