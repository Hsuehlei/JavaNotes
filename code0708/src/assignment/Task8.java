package assignment;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/8 17:28
 */
public class Task8 {

    public static void main(String[] args) {

        String orginal = "hanbasdnbafllgnbahjnbakqqqqlnbaxi";

        int i = 0;
        boolean flag = true;
        while (flag) {
            int x = orginal.indexOf("nba");
            if (x>=0) {
                i++;
                orginal = orginal.substring(x+3);
            }
            if (x==-1) {
                flag = false;
            }
        }
        System.out.println(i);



        //改进版
        String a = "hanbasdnbafllgnbahjnbakqqqqlnbaxi";
        String nba = a.replaceAll("nba", "");
        System.out.println((a.length() - nba.length())/3);
    }
}
