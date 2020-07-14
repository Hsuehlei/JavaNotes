package assignment3;

import java.util.*;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/13 21:12
 */
public class Test {

    public static void main(String[] args) {
        //Set不可重复
        //HashSet是否重复，会比较hash值
        //TreeSet能否放入，看的是比较结果
        Random r = new Random();
        Set<Student> set = new HashSet<>(25);

        for (int i = 0; i < 20; i++) {
            int x = r.nextInt(40) + 1;
            int y = r.nextInt(100) + 1;

            if (!set.contains(x)) {
                set.add(new Student(x, y));
            } else {
                i--;
            }
        }

        Iterator<Student> iterator = set.iterator();

        int max = 0;
        int min = 0;
        while (iterator.hasNext()) {
            Student s = (Student) iterator.next();
            if (s.getScore() > max) {
                max = s.getScore();
            } else if (s.getScore() < min) {
                min = s.getScore();
            }
        }

        System.out.println("Max:" + max);
        System.out.println("Min:" + min);


    }
}
