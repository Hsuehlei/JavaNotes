/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/9 19:30
 */
public class Task1 {

    public static void main(String[] args) {

        String str = "958324861";

        long time1 = System.currentTimeMillis();
        char[] ch = str.toCharArray();
        StringBuilder x = new StringBuilder();
        for (char c : ch) {
            x.append(c);
        }
        System.out.println(x);
        long time2 = System.currentTimeMillis();
        int time3 = (int)(time2 - time1);
        System.out.println(time1);
        System.out.println(time2);

        long time4 = System.currentTimeMillis();
        int i = Integer.parseInt(str);
        System.out.println(i);
        long time5 = System.currentTimeMillis();
        long time6 = time5 - time4;

        System.out.println(time3);
        System.out.println(time4);
        System.out.println(time5);

        System.out.println(time6);
    }
}
