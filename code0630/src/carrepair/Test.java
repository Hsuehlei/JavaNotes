package com.javasm.task.carrepair;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/30 16:38
 */
public class Test {

    public static void main(String[] args) {

        Car carYellow = new Car(2, "yellow");

        if (carYellow.wheelNum >= 4) {
            carYellow.run();
        } else {
            Garage garage = new Garage("shidaiweixiu", "zz863", "0371-666666");
            garage.repair(carYellow);
        }
    }
}
