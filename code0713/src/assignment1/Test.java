package assignment1;

import java.util.ArrayList;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/13 19:59
 */
public class Test {
    public static void main(String[] args) {

        ArrayList<Object> arrayList = new ArrayList<>(10);

        SoftwareEngineer softwareEngineer1 = new SoftwareEngineer("张三",22,1001);
        SoftwareEngineer softwareEngineer2 = new SoftwareEngineer("李四",23,1002);

        ProjectManager projectManager1 = new ProjectManager("王五",32,'男');
        ProjectManager projectManager2 = new ProjectManager("赵六",33,'男');

        arrayList.add(softwareEngineer1);
        arrayList.add(softwareEngineer2);
        arrayList.add(projectManager1);
        arrayList.add(projectManager2);

        for (Object o : arrayList) {
            System.out.println(o);
        }
    }
}
