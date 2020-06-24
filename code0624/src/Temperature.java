/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/24 19:36
 * @description 定义今日温度，单位摄氏度，求对应华氏度是多少
 *              摄氏度 = (华氏度 - 32) * 5 / 9
 */
public class Temperature {
    public static void main(String[] args) {
        double todayTemperature = 39.0;

        double fahrenheit = todayTemperature * 9 / 5 + 32;

        System.out.println("今日华氏" + fahrenheit + "度");
    }
}
