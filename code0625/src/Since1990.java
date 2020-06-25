import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/25 19:50
 * @description 计算用户输入的日期离1900年1月1日相距多少天
 */
public class Since1990 {
    public static void main(String[] args) {

        int first = 1900;
        int leapYearTimes = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入日期（如：2000）：");
        int year = sc.nextInt();
        System.out.println("请输入日期（如：05）：");
        int month = sc.nextInt();
        System.out.println("请输入日期（如：05）：");
        int day = sc.nextInt();

        for (int i = first; i <= year; i++) {
            if (year % 4 == 0 && year % 100 != 0) {
                leapYearTimes++;
            }
        }

        int yearDay = (year - 1900) * 365 + leapYearTimes;
        int monthDay;
        int dayDay = day - 1;

        switch (month) {
            case 1:
                monthDay = 0;
                break;
            case 2:
                monthDay = 31;
                break;
            case 3:
                monthDay = 31 + 28;
                break;
            case 4:
                monthDay = 31 + 28 + 31;
                break;
            case 5:
                monthDay = 31 + 28 + 31 + 30;
                break;
            case 6:
                monthDay = 31 + 28 + 31 + 30 + 31;
                break;
            case 7:
                monthDay = 31 + 28 + 31 + 30 + 31 + 30;
                break;
            case 8:
                monthDay = 31 + 28 + 31 + 30 + 31 + 30 + 31;
                break;
            case 9:
                monthDay = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
                break;
            case 10:
                monthDay = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
                break;
            case 11:
                monthDay = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
                break;
            default:
                monthDay = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
        }

        int total = yearDay + monthDay + dayDay;

        System.out.println("1900年1月1日距输入的天数大概" + total + "天");
    }
}
