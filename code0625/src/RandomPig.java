import java.util.Random;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/25 19:29
 * @description 让计算机随机产生10个0到2之间的数
 *              如果产生的是0就输出“生成了一只白猪，我好怕怕”
 *              如果产生的是1就输出“生成了一只黑猪，我喜欢”
 *              如果产生的是2就输出“生成了一只红猪，有下酒菜了”
 */
public class RandomPig {
    public static void main(String[] args) {

        Random r = new Random();

        for (int i = 1; i < 11; i++) {
            int x = r.nextInt(3);
            switch (x) {
                case 0:
                    System.out.println("生成了一只白猪，我好怕怕");
                    break;
                case 1:
                    System.out.println("生成了一只黑猪，我喜欢");
                    break;
                default:
                    System.out.println("生成了一只红猪，有下酒菜了");
            }
        }
    }
}
