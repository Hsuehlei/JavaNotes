package assignment2;

import java.util.Random;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/17 20:47
 */
public class ProducerConsumer {

    private int productCount;
    private final int maxProductCount = 10;
    Random r = new Random();

    public void product() {
        synchronized (this) {
            while (productCount == maxProductCount) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("生产者开始生产");
            int second = r.nextInt(501) + 1000;

            try {
                Thread.sleep(second);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            productCount++;
            System.out.println(Thread.currentThread().getName() + " - 生产者 - 生产了一个产品");
            System.out.println("当前库存为：" + productCount);
            System.out.println("---------------");
            notifyAll();
        }
    }

    public void consume() {
        synchronized (this) {
            while (productCount == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("消费者开始消费");

            int second = r.nextInt(1001) + 2000;
            try {
                Thread.sleep(second);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            productCount--;
            System.out.println(Thread.currentThread().getName() + " - 消费者 - 消费了一个产品");
            System.out.println("当前库存为：" + productCount);
            System.out.println("---------------");
            notifyAll();
        }
    }
}
