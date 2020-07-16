package assignment5;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/16 15:11
 */
public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> arrayList = new ArrayList<>();

        System.out.println("添加学生信息请选1：");
        System.out.println("查看学生信息请选2：");
        int x = sc.nextInt();
        if (x == 1) {
            addStuInfo(sc, arrayList);
        } else if (x == 2) {
            showInfo();
        } else {
            System.out.println("您的输入有误");
            System.out.println("请重新输入");
        }
    }

    public static void addStuInfo(Scanner sc, ArrayList<Student> arrayList) {

        while (true) {
            Student student = new Student();
            System.out.println("请输入学号：");
            String stuId = sc.next();
            System.out.println("请输入姓名：");
            String stuName = sc.next();
            System.out.println("请输入性别：");
            char stuGender = sc.next().charAt(0);

            student.setId(stuId);
            student.setName(stuName);
            student.setGender(stuGender);

            boolean flag = false;
            for (Student s : arrayList) {
                if (s.getId().equals(stuId)) {
                    System.out.println("该学号已存在");
                    System.out.println("请重新输入");
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                arrayList.add(student);
                System.out.println("是否继续添加(y/n)：");
                if ("n".equalsIgnoreCase(sc.next())) {
                    try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                            new FileOutputStream("./resources/student.dat"))) {
                        objectOutputStream.writeObject(arrayList);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    public static void showInfo() {

        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("./resources/student.dat"))) {
            ArrayList<Student> arrayList = (ArrayList<Student>) objectInputStream.readObject();

            arrayList.forEach( s -> {
                System.out.println(s.show());
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
