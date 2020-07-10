package assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/10 15:32
 */
public class Task2 {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        System.out.println("年：");
        int year = sc.nextInt();
        System.out.println("月：");
        int month = sc.nextInt();
        System.out.println("日：");
        int day = sc.nextInt();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month,day);
        Date date = calendar.getTime();
        System.out.println(date);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

        /*LocalDate localDate = LocalDate.of(year,month,day);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String str = formatter.format(localDate);
        System.out.println(localDate);
        System.out.println(str);

        localDate = LocalDate.parse(str);
        System.out.println(localDate);*/
    }
}
