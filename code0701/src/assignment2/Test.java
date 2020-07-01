package exercise.assignment2;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/1 16:59
 */
public class Test {

    public static void main(String[] args) {

        Rectangle rec = new Rectangle(20.0,60.0);

        System.out.println("面积为" + rec.area());
        System.out.println("周长为" + rec.perimeter());
    }
}
