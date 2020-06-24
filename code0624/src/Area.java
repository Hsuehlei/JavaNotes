/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/24 19:12
 * @description 韩梅梅看中两把价格相同的扇子，想挑选一个扇面较大的扇子购买，请你帮她挑选。
 *              A款折叠扇：展开后角度为134.6°,扇骨长26.5cm
 *              B款圆扇：扇柄长12.3cm，扇子总长度36.5cm
 *              注：圆形面积 = 3.14 * 半径平方
 *  	        扇形面积 = 3.14 * 半径平方 * (度数/360)
 *              Java中π用Math.PI表示
 */
public class Area {
    public static void main(String[] args) {
        double angle = 134.6;
        double aLength = 26.5;

        double bLength = 12.3;
        double totalLength = 36.5;
        //直径
        double diameter = totalLength - bLength;

        double aArea = Math.PI * aLength * aLength * (angle / 360);
        double bArea = Math.PI * diameter * diameter / 4;

        System.out.println(aArea > bArea ? "买A": "买B");
    }
}
