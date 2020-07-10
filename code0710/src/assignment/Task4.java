package assignment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/10 17:53
 */
public class Task4 {

    public static void main(String[] args) {

        int year = 2020;
        int month = 7;

        Calendar calendar = Calendar.getInstance();
        // 设置时间,当前时间不用设置
        calendar.set(Calendar.YEAR, Integer.parseInt(String.valueOf(year)));
        calendar.set(Calendar.MONTH, Integer.parseInt(String.valueOf(month)));

        // System.out.println(calendar.getTime());

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        String s = format.format(calendar.getTime());
        System.out.println(s);
    }
}
