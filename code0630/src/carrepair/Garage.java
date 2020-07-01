package com.javasm.task.carrepair;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/30 16:32
 */
public class Garage {

    String name;
    String address;
    String phone;

    Garage(String na, String ad, String ph) {
        name = na;
        address = ad;
        phone = ph;
    }

    /**
     *
     */
    public void repair(Car car) {
        System.out.println("我正在修的车的颜色是：" + car.color);
        System.out.println("这个车有" + car.wheelNum + "轮子");
        System.out.println("这个车确实需要维修");
        System.out.println("我在修车中=================");
        System.out.println("我修好了");
    }
}
