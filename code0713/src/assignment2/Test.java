package assignment2;

import assignment1.ProjectManager;
import assignment1.SoftwareEngineer;

import java.util.HashMap;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/13 20:42
 */
public class Test {

    public static void main(String[] args) {

        assignment1.SoftwareEngineer softwareEngineer1 = new assignment1.SoftwareEngineer("张三", 22, 1001);
        assignment1.SoftwareEngineer softwareEngineer2 = new SoftwareEngineer("李四", 23, 1002);

        assignment1.ProjectManager projectManager1 = new assignment1.ProjectManager("王五", 32, '男');
        assignment1.ProjectManager projectManager2 = new ProjectManager("赵六", 33, '男');

        HashMap<Integer, Object> hashMap = new HashMap<>(10);

        hashMap.put(1, softwareEngineer1);
        hashMap.put(2, softwareEngineer2);
        hashMap.put(3, projectManager1);
        hashMap.put(4, projectManager2);

        hashMap.forEach((k, v) -> {
            System.out.println(k + "\t");
            System.out.println(v);
        });

    }
}
