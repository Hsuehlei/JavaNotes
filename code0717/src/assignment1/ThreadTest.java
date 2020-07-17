package assignment1;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/17 20:34
 */
public class ThreadTest {

    public static void main(String[] args) {

        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread1 = new Thread(threadDemo);
        Thread thread2 = new Thread(threadDemo);
        thread1.start();
        thread2.start();

        Thread thread = new Thread();
        for (int i = 0; i < 5; i++) {
            System.out.println(thread.getName());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
