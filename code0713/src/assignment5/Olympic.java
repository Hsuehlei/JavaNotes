package assignment5;

import java.util.*;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/13 22:04
 */
public class Olympic {

    public static void main(String[] args) {

        Random r = new Random();
        String[] str = {"科特迪瓦","阿根廷","澳大利亚","塞尔维亚","荷兰","尼日利亚","日本",
                "美国","中国","新西兰","巴西","比利时","韩国","喀麦隆","洪都拉斯","意大利"};

        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, str);
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 4; i++) {
            System.out.println("第" + (i+1) + "组如下");
            for (int j = 0; j < 4; j++) {

                int x = r.nextInt(16);

                if (!set.contains(x)) {
                    System.out.println(arrayList.get(x));
                    set.add(x);
                } else {
                    j--;
                }

            }

        }

     }
}
