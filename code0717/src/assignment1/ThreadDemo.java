package assignment1;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/17 20:33
 */
public class ThreadDemo extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
