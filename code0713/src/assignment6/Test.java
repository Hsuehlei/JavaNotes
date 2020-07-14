package assignment6;

import assignment4.Student;

import java.util.*;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/13 22:26
 */
public class Test {

    public static void main(String[] args) {

        List<Object> list = new ArrayList<>();
        list.add(new Account(10.00, "1234"));
        list.add(new Account(15.0, "5678"));
        list.add(new Account(0, "1010"));

        HashMap<Long, Object> hashMap = new HashMap<>(10);
        int j = 0;
        for (long i = 1000; i < (1000 + list.size()); i++, j++) {
            hashMap.put(i, list.get(j));
        }

        Set<Long> set = hashMap.keySet();
        for (Long aLong : set) {
            System.out.print("id=" + aLong + "\t");
            System.out.println(hashMap.get(aLong));
        }

    }
}
