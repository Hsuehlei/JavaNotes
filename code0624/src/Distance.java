/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/24 19:05
 * @description 求一光年是多少千米，光在真空中传播速度299792458 m/s
 */
public class Distance {
    public static void main(String[] args) {
        int second = 60;
        int minute = 60;
        int hour = 24;
        int year = 365;
        long v = 299792458;

        //如果year不是long类型，下面表达式等号右边乘出的结果一定是int，然后造成数据溢出
        long distance = (second * minute * hour * year * v)/1000L;
        System.out.println("一光年的距离是" + distance + "千米");
    }
}
