package assignment5;

import java.util.*;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/13 22:26
 */
public class Test {

    public static void main(String[] args) {

        List<Account> list = new ArrayList<>();
        list.add(new Account(10.00, "1234"));
        list.add(new Account(15.0, "5678"));
        list.add(new Account(0.0, "1010"));

        HashMap<Long, Account> hashMap = new HashMap<>(10);

        list.forEach(s -> {
            hashMap.put(s.getId(), s);
        });

        hashMap.forEach((k, v) -> {
            System.out.println(v.getId());
            System.out.println(v.getBalance());
        });

    }
}
