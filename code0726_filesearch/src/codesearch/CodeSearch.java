package codesearch;

import java.io.File;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/26 19:22
 */
public class CodeSearch {

    static int count = 0;
    static double totalMemory = 0;

    public static void main(String[] args) {

        File file = new File("D:\\code-work");
        printDir(file);
        System.out.println(count);
        double visualMemory = totalMemory/8/1000;
        System.out.println(visualMemory + "KB");
    }

    public static void printDir(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                if (file.getName().endsWith("java")) {
                    System.out.println("文件名：" + file.getAbsolutePath());
                    totalMemory += file.length();
                    count++;
                }
            } else {
                printDir(file);
            }
        }
    }
    
}
