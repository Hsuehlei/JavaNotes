package landlord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/25 20:09
 */
public class LandLordV2 {

    public static void main(String[] args) {

        HashMap<Integer, String> pokerMap = new HashMap<>(60);

        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();

        Collections.addAll(colors,"♠","♥","♣","♦");
        Collections.addAll(numbers,"A","2","3","4","5","6","7",
                "8","9","10","J","Q","K");

        int count = 1;
        pokerMap.put(count++, "大🃏");
        pokerMap.put(count++, "小🃏");

        for (String color : colors) {
            for (String number : numbers) {
                String card = color + number;
                pokerMap.put(count++, card);
            }
        }

        Set<Integer> numberSet = pokerMap.keySet();

        ArrayList<Integer> numberList = new ArrayList<>();
        //addAll()：后可以跟集合
        numberList.addAll(numberSet);
        Collections.shuffle(numberList);

        ArrayList<Integer> player1 = new ArrayList<Integer>();
        ArrayList<Integer> player2 = new ArrayList<Integer>();
        ArrayList<Integer> player3 = new ArrayList<Integer>();
        ArrayList<Integer> holeCard = new ArrayList<Integer>();

        for (int i = 0; i < numberList.size(); i++) {
            Integer no = numberList.get(i);
            if (i >= 51) {
                holeCard.add(no);
            } else {
                if (i % 3 == 0) {
                    player3.add(no);
                } else if (i % 3 == 1) {
                    player2.add(no);
                } else {
                    player1.add(no);
                }
            }
        }

        //查看牌，按照牌的大小排序
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(holeCard);

        ArrayList<String> play1 = new ArrayList<>();
        ArrayList<String> play2 = new ArrayList<>();
        ArrayList<String> play3 = new ArrayList<>();
        ArrayList<String> hoCard = new ArrayList<>();

        for (Integer i : player1) {
            String card = pokerMap.get(i);
            play1.add(card);
        }
        for (Integer i : player2) {
            String card = pokerMap.get(i);
            play2.add(card);
        }
        for (Integer i : player3) {
            String card = pokerMap.get(i);
            play3.add(card);
        }
        for (Integer i : holeCard) {
            String card = pokerMap.get(i);
            hoCard.add(card);
        }

        System.out.println("林青霞：" + play1);
        System.out.println("王祖贤：" + play2);
        System.out.println("我：" + play3);
        System.out.println("底牌：" + hoCard);


    }
}
