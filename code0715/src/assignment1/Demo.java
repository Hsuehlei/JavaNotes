package assignment1;

import java.io.*;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/15 19:03
 */
public class Demo {

    public static void main(String[] args) {

        makeDir();
    }

    public static void makeDir() {
        File file = new File("./resources/demo/");

        if (!file.exists()) {
            file.mkdirs();
        }

        try (FileInputStream fileInputStream = new FileInputStream("./resources/test.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("./resources/demo/test.txt")) {
            int num;
            while ((num = fileInputStream.read()) != -1) {
                fileOutputStream.write(num);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
