package assignment1;

import java.util.*;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/13 19:59
 */
public class Test {
    public static void main(String[] args) {

        ArrayList<Employee> arrayList = new ArrayList<>(10);
        Employee aa = new SoftwareEngineer(1001, "aa", 66.66, 2);
        Employee bb = new SoftwareEngineer(1002, "bb", 66.66, 2);
        Employee cc = new ProjectManager(2001, "cc", 88.88, 22.22);
        Employee dd = new ProjectManager(2002, "dd", 88.88, 22.22);

        arrayList.add(aa);
        arrayList.add(bb);
        arrayList.add(cc);
        arrayList.add(dd);

        arrayList.forEach(al -> {
            System.out.println(al.show());
        });

        HashMap<Integer, Employee> integerEmployeeHashMap = new HashMap<>(10);
        integerEmployeeHashMap.put(aa.getId(), aa);
        integerEmployeeHashMap.put(bb.getId(), bb);
        integerEmployeeHashMap.put(cc.getId(), cc);
        integerEmployeeHashMap.put(dd.getId(), dd);

        //得到的是value的集合
        Collection<Employee> values = integerEmployeeHashMap.values();
        //拿到key集合，循环遍历
        Set<Integer> set = integerEmployeeHashMap.keySet();
        for (Integer key : set) {
            System.out.println(integerEmployeeHashMap.get(key).show());
        }

        //foreach,1.8之后
        integerEmployeeHashMap.forEach((k, v) -> {
            System.out.println(v.show());
        });

        //entries是key-value对的集合，Entry采用内部类表示映射项，映射项中包含key和value
        Set<Map.Entry<Integer, Employee>> entries = integerEmployeeHashMap.entrySet();
        for (Map.Entry<Integer, Employee> entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}
