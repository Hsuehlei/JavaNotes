import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/30 15:59
 */
public class MD5Test {

    public static void main(String[] args) {
        String vipPassword = "123456";
        //MD5加密
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(vipPassword.getBytes());
            byte[] encodeBy = messageDigest.digest();
            BigInteger bigInteger = new BigInteger(1, encodeBy);
            String str = bigInteger.toString(16);
            System.out.println(str);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
