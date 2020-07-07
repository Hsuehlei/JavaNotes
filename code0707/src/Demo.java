import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/7 10:33
 */
public class Demo {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        try {
            sdf.parse("522");
            System.out.println(1/0);
        } catch (ParseException | ArithmeticException e) {
            e.printStackTrace();
        } finally {
            System.out.println("异常已经解决了");
        }
    }
}
