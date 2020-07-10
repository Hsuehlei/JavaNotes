package assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/10 19:43
 */
public class Task6 {

    public static void main(String[] args) throws ParseException {

        newDate("2020-07-10",10);
    }

    public static void newDate(String date1,int days) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(date1);
            Calendar cl = Calendar.getInstance();
            cl.setTime(date);
            cl.add(Calendar.DATE, days);
            String temp = "";
            temp = sdf.format(cl.getTime());
            System.out.println(temp);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
