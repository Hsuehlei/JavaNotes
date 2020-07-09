package assignment;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/9 19:11
 */
public class Task9 {

    public static void main(String[] args) {
        String str = "E:\\jboss-4.0.4.GA\\server\\minimal\\conf\\readme.txt";


        System.out.println(str.substring(0, str.indexOf("\\")));

        System.out.println(str.substring(str.lastIndexOf("\\") + 1, str.lastIndexOf(".")));
        System.out.println(str.substring(str.lastIndexOf(".") + 1));
    }
}
