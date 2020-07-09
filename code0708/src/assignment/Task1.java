package assignment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/9 14:39
 */
public class Task1 {

    public static void main(String[] args) {
        //判断邮箱是否合法
        String str1 = "we235423wefw@sina.com";
        System.out.println(str1.matches("^\\w+@\\w+\\.com$"));

        //加强版
        String str2 = "1342352sfw@qq.com";
        Pattern p = Pattern.compile("(\\w+)@(\\w+)\\.\\w+");
        Matcher m = p.matcher(str2);
        //一定要匹配上 才有分组
        System.out.println(m.matches());
        System.out.println(m.group(0));
        System.out.println(m.group(1));
        System.out.println(m.group(2));

        //Pattern类
        //必须首先将正则表达式（指定为字符串）编译为此类的实例。
        //然后将所得的图案可以被用来创建一个Matcher对象可以匹配任意character sequences针对正则表达式。
        //执行匹配的所有状态都驻留在匹配器中，所以许多匹配者可以共享相同的模式。
        //标准流程如下
        /*Pattern p = Pattern.compile("a*b");
        Matcher m = p.matcher("aaaaab");
        boolean b = m.matches();*/
    }
}
