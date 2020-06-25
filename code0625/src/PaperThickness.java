/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/25 19:41
 * @description 一张纸的厚度大约是0.08mm，对折多少次之后能达到珠穆朗玛峰的高度（8848.13米）？
 */
public class PaperThickness {
    public static void main(String[] args) {

        double paperThick = 0.08;
        double mountain = 8848130;
        int numOfTimes = 0;

        while (mountain >= paperThick) {
            paperThick *= 2;
            numOfTimes++;
            System.out.println(paperThick);
        }

        System.out.println("对折" + numOfTimes + "次后能达到珠穆朗玛峰的高度");
    }
}
