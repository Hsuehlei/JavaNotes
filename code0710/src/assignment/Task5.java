package assignment;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


/**
 *
 * @author Lei
 * @version 1.0
 * @date 2020/7/10 19:07
 */
public class Task5 {

    public static void main(String[] args) {

        Instant instant = Instant.now();
        Instant instant1 = instant.plusSeconds(8 * 60 * 60);
        long duration = instant.until(instant1, ChronoUnit.HOURS);
        System.out.println(duration);
    }
}
