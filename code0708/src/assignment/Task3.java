package assignment;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/9 17:33
 */
public class Task3 {

    public static void main(String[] args) {

        String str1 = "aabbccdd";
        String str2 = "abcdabcee";

        int length1 = str1.length();
        int length2 = str2.length();

        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();

        boolean flag = false;

        //k为比较正确的次数
        int k = 0;
        char temp;

        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (a[i] == b[j]) {
                    temp = b[j];
                    b[j] = b[i];
                    b[i] = temp;
                    k++;
                    break;
                }
            }
        }

        if (k == length1) {
            flag = true;
        }

        //比较正确次数为字符数的长度
        if (flag) {
            System.out.println("两个字符一致");
        } else {
            System.out.println("两个字符不一致");
        }
    }
}
