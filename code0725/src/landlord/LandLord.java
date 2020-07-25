package landlord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/25 15:46
 */
public class LandLord {

    public static void main(String[] args) {

        //存牌面
        ArrayList<String> pokerBox = new ArrayList<>();
        //存花色
        ArrayList<String> colors = new ArrayList<>();
        //存数字
        ArrayList<String> numbers = new ArrayList<>();

        colors.add("♠");
        colors.add("♥");
        colors.add("♣");
        colors.add("♦");

        for (int i = 2; i < 11; i++) {
            //i 加上一个字符串，i就变成了一个字符串
            numbers.add(i + "");
        }
        numbers.add("J");
        numbers.add("Q");
        numbers.add("K");
        numbers.add("A");

        for (String color : colors) {
            for (String number : numbers) {
                pokerBox.add(color+number);
            }
        }

        pokerBox.add("小🃏");
        pokerBox.add("大🃏");

        //shuffler()：使用默认的随机源对指定列表进行置换
        Collections.shuffle(pokerBox);

        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> holeCard = new ArrayList<>();

        for (int i = 0; i < pokerBox.size(); i++) {
            String card = pokerBox.get(i);
            if (i >= 51) {
                holeCard.add(card);
            } else {
                if (i % 3 ==0) {
                    player1.add(card);
                    //不能用”i % 2 == 0“
                } else if(i % 3 ==1) {
                    player2.add(card);
                } else {
                    player3.add(card);
                }
            }
        }

        System.out.println("王祖贤：" + player1);
        System.out.println("迪丽热巴：" + player2);
        System.out.println("我：" + player3);
        System.out.println("底牌：" + holeCard);
    }
}
