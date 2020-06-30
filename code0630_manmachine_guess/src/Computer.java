import java.util.Random;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/30 11:48
 */
public class Computer {

    String shear = "剪刀";
    String stone = "石头";
    String cloth = "布";
    int flag = 0;

    public void showFist() {

        Random r = new Random();
        int x = r.nextInt(3) + 1;

        switch (x) {
            case 1:
                System.out.println("电脑出拳：" + shear);
                flag = 1;
                break;
            case 2:
                System.out.println("电脑出拳：" + stone);
                flag = 2;
                break;
            default:
                System.out.println("电脑出拳：" + cloth);
                flag = 3;
        }
    }
}
