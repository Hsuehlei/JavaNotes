package com.javasm.task.carrepair;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/30 16:30
 */
public class Car {

    public static int num;
    int wheelNum;
    String color;

    Car(int wh, String co) {
        wheelNum = wh;
        color = co;
    }

    public void run() {
        System.out.println("这个车正在跑");
    }
}
