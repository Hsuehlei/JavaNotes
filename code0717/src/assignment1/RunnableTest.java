package assignment1;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/17 20:40
 */
public class RunnableTest {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new RunnableDemo());
        Thread thread2 = new Thread(new RunnableDemo());
        thread1.start();
        thread2.start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
