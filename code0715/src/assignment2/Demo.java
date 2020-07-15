package assignment2;

import java.io.File;
import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/15 19:15
 */
public class Demo {

    public static void main(String[] args) {

        System.out.println("请输入一个文件目录：");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        File file = new File(str);
        if (file.exists()) {
            findDir(file);
        } else {
            System.out.println("这条路径不存在");
        }

    }

    public static void findDir(File file) {
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File file1 : files) {
                if (file1.isFile()) {
                    System.out.println("\t|" + file1.getName());
                } else {
                    System.out.println("|" + file1.getName());
                    findDir(file1);
                }
            }
        }
    }
}
