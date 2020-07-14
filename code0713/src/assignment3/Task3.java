package assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/13 20:48
 */
public class Task3 {

    public static void main(String[] args) {

        HashMap<Integer, String> hashMap = new HashMap<>(7);
        hashMap.put(0,"星期一");
        hashMap.put(1,"星期二");
        hashMap.put(2,"星期三");
        hashMap.put(3,"星期四");
        hashMap.put(4,"星期五");
        hashMap.put(5,"星期六");
        hashMap.put(6,"星期日");

        int days = dateTime();
        if (days == -1) {
            System.out.println("时间转换异常");
        } else {
            //获取月份时：一月是0，二月是1，以此类推，12月是11
            //获取星期时：周一是2，周二是3 ，，，，，周六是7，周日是1
            System.out.println(hashMap.get(days-1));
        }
    }

    public static int dateTime() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的时间(yyyy-MM-dd)：");
        String str = sc.next();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            int days = calendar.get(Calendar.DAY_OF_WEEK);
            return days;
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
        return -1;
    }
}
