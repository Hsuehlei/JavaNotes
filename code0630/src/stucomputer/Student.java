package com.javasm.task.stucomputer;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/30 16:44
 */
public class Student {

    String name;
    String stuId;
    char gender;
    Computer cu;

    Student() {
    }

    Student(String na, String id, char ge, Computer computer) {
        name = na;
        stuId = id;
        gender = ge;
        cu = computer;
    }

    public void study() {
        System.out.println("我正在学习");
        System.out.println("我正在用" + cu.brand + "学习");
    }

    public void eat() {
        System.out.println("我正在吃饭");
    }
}
