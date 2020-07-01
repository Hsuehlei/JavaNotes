package com.javasm.task.stucomputer;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/30 16:46
 */
public class Computer {

    String brand;
    String cpu;
    String display;

    Computer(String br, String cp, String dis) {
        brand = br;
        cpu = cp;
        display = dis;
    }

    public void online() {
        System.out.println("正在使用电脑上网");
    }
}
