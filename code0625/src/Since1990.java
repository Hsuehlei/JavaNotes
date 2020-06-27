import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/25 19:50
 * @description 计算用户输入的日期离1900年1月1日相距多少天
 */
public class Since1990 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();

        int sumDay = day - 1;

        //年相差
        for (int i = 1900; i < year; i++) {
            if (((i % 4 == 0) && (i % 100 != 0)) || i % 400 == 0) {
                sumDay = sumDay + 366;
            } else {
                sumDay = sumDay + 365;
            }
        }

        for (int i = 1; i < month; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    sumDay += 31;
                    break;
                case 2:
                    if (((i % 4 == 0) && (i % 100 != 0)) || i % 400 == 0) {
                        sumDay = sumDay + 29;
                    } else {
                        sumDay = sumDay + 28;
                    }
                    break;
                default:
                    sumDay += 30;
            }
        }
        System.out.println(sumDay);
    }
}
