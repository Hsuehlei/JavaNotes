package assignment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/9 19:17
 */
public class Task12 {

    public static void main(String[] args) {

        String str1 = "我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程";
        String replaceStr = str1.replaceAll("\\.", "");
        System.out.println(replaceStr);
        Pattern p = Pattern.compile("(.)\\1+");
        Matcher m = p.matcher(replaceStr);
        m.find();
        while (m.find()) {
            System.out.println(m.group(1));
        }
    }
}
