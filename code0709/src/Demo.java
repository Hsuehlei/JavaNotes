/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/9 11:04
 */
public class Demo {

    public static void main(String[] args) {

        /*String str = "javaaaaa";

        //*，0或多次
        System.out.println(str.matches("java*"));
        //+，至少一次
        System.out.println(str.matches("java+"));
        //？，0或1
        System.out.println(str.matches("java*"));
        //3次
        System.out.println(str.matches("java{3}"));
        //至少3次
        System.out.println(str.matches("3,"));
        //3到5次
        System.out.println(str.matches("java{3,5}"));*/
        byte by = 10;
        Byte by1 = new Byte(by);
        float f = 1.0F;
        Float f1 = new Float(f);
        Character[] characters = {'a','M','6',' ',65};
        for (char c:characters) {
            if (Character.isDigit(c)) {
                System.out.println(c + "是数字");
            } else if (Character.isWhitespace(c)) {
                System.out.println(c + "is whitespace");
            } else if (Character.isUpperCase(c)) {
                System.out.println(c + "是大写字母");
            } else if (Character.isLowerCase(c)) {
                System.out.println(c + "是小写字母");
            }
        }

        int a = 123456;
        Integer integer = a;
        System.out.println(integer);

        System.out.println(Math.pow(2.0,3));
        System.out.println(Math.abs(-1));
        System.out.println(Math.sqrt(9.0));
        System.out.println(Math.random());
        System.out.println(Math.round(1.5));
        System.out.println(Math.ceil(12.2));
        System.out.println(Math.pow(2.0,3));
        System.out.println(Math.pow(2.0,3));

    }
}
