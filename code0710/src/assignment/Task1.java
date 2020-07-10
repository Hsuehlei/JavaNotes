package assignment;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/10 15:14
 */
public class Task1 {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.systemDefault());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println(dateTimeFormatter.format(localDateTime));

        String str = dateTimeFormatter.format(localDateTime);

        System.out.println(str);

        localDateTime = LocalDateTime.parse(str,dateTimeFormatter);

        System.out.println(localDateTime);


    }
}
