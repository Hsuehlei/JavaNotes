package assignment2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/17 21:10
 */
public class Test {

    public static void main(String[] args) {

        ProducerConsumer producerConsumer = new ProducerConsumer();

        FutureTask task1 = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                while (true) {
                    producerConsumer.product();
                }
            }
        });

        FutureTask task2 = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                while (true) {
                    producerConsumer.consume();
                }
            }
        });

        new Thread(task1).start();
        new Thread(task2).start();

//        do {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    producerConsumer.product();
//                }
//            }).start();
//
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    producerConsumer.consume();
//                }
//            }).start();
//        } while (true);
    }
}
