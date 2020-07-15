package assignment3;

import java.io.*;
import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/15 19:28
 */
public class Demo {

    public static void main(String[] args) {

        System.out.println("输入字符串：");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./resources/log.txt"))) {
            bufferedWriter.write(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
