package com.javasm.task.stucomputer;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/30 16:51
 */
public class Test {
    public static void main(String[] args) {

        Computer cu = new Computer("HW", "AMD", "VOC");
        Student stu = new Student("anne", "70067", '女', cu);
        stu.study();
    }
}
