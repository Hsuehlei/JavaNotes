/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/30 11:10
 */
public class User {

    String shear = "剪刀";
    String stone = "石头";
    String cloth = "布";

    public void showFist(int x) {
        switch (x) {
            case 1:
                System.out.println("你出拳：" + shear);
                break;
            case 2:
                System.out.println("你出拳：" + stone);
                break;
            case 3:
                System.out.println("你出拳：" + cloth);
                break;
            default:
                System.out.println("理解不能，请重新输入！");
        }
    }
}
