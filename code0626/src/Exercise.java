import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/6/26 17:05
 */
public class Exercise {
    public static void main(String[] args) {

//        demo();
//        demo1();
//        demo2();
//        demo3();
        demo4();
        demo5();
//        demo6();
//        demo7();
//        demo8(10);
    }

    /**
     * 在歌唱比赛中，共有10位评委进行打分，在计算歌手得分时，去掉一个最高分，去掉一个最低分，
     * 然后剩余的8位评委的分数进行平均，就是该选手的最终得分。输入每个评委的评分，求某选手的得分
     */
    public static void demo() {
        Scanner sc = new Scanner(System.in);
        
        int[] judegsScores = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("请输入第" + (i + 1) + "个评委的评分：");
            judegsScores[i] = sc.nextInt();
        }

        int max = judegsScores[0];
        int min = judegsScores[0];
        for (int x : judegsScores) {
            max = max > x ? max : x;
            min = min < x ? min : x;
        }

        int sum = 0;
        for (int i = 0; i < judegsScores.length; i++) {
            sum += judegsScores[i];
        }

        double totalSum = sum - max - min;
        double avgScore = totalSum / (judegsScores.length - 2);
        System.out.println("该选手的平均最终得分是：" + avgScore);
    }

    /**
     * 声明一个字符串的数组，空间为5个。使用循环接收五个学生的姓名。再使用循环输出这五个学生的姓名
     */
    public static void demo1() {
        String[] str = new String[5];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < str.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个学生的名字：");
            str[i] = sc.next();
        }

        for (String x : str) {
            System.out.println(x);
        }
    }

    /**
     * 声明一个int型的数组，循环接收8个学生的成绩，计算这8个学生的总分、平均分、最高分、最低分
     */
    public static void demo2() {
        int[] stuScore = new int[8];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < stuScore.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个学生的成绩：");
            stuScore[i] = sc.nextInt();
        }

        int maxScore = stuScore[0];
        int minScore = stuScore[0];
        double sumScore = 0;
        for (int x : stuScore) {
            maxScore = maxScore > x ? maxScore : x;
            minScore = minScore < x ? minScore : x;
            sumScore += x;
        }

        double avgScore = sumScore / stuScore.length;

        System.out.println("这8个学生的总分是" + sumScore);
        System.out.println("这8个学生的平均分是" + avgScore);
        System.out.println("这8个学生的最高分是" + maxScore);
        System.out.println("这8个学生的最低分是" + minScore);
    }

    /**
     * 现在有如下一个数组：int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5}; 要求将以上数组中的0项去掉，
     * 将不为0的值存入一个新的数组，生成新的数组为 int newArr[]={1,3,4,5,6,6,5,4,7,6,7,5};
     */
    public static void demo3() {
        int[] oldArr = {1, 3, 4, 5, 0, 0, 6, 6, 0, 5, 4, 7, 6, 7, 0, 5};
        int zeroNum = 0;

        for (int x : oldArr) {
            if (x == 0) {
                zeroNum++;
            }
        }

        //变量的作用域是从定义的位置开始到相邻最近的大括号处
        int arrLength = oldArr.length - zeroNum;
        int[] newArr = new int[arrLength];
        int subscript = 0;

        for (int x : oldArr) {
            if (x != 0) {
                newArr[subscript] = x;
                subscript++;
            }
        }

        System.out.println(Arrays.toString(newArr));
    }

    /**
     * 有一整数数组，｛1，3，-1，5，-2｝，将数据复制到新数组中 ，要求逆序输出新数组中的数，
     * 同时并将小于0的元素按0存储
     */
    public static void demo4() {
        int[] oldArr = {1, 3, -1, 5, -2};
        System.out.println(Arrays.toString(oldArr));
        int len = oldArr.length;
        int temp;
        boolea flag = false;
        
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (oldArr[j] > oldArr[j + 1]) {
                    flag = ture;
                    temp = oldArr[j + 1];
                    oldArr[j + 1] = oldArr[j];
                    oldArr[j] = temp;
                }
            }
            
            //在一趟排序中，一次交换都没有发生
            if (!flag) {
                break;
            } else {
                //重置flag，进行下次判断
                flag = false;
            }
        }
        System.out.println(Arrays.toString(oldArr));

        int sp = len - 1;
        int[] arr = new int[len];
        for (int x : oldArr) {
            arr[sp] = x;
            sp--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * int array [] = {2,432,5221,235,2,5352,1,53,5,3,5364,2,2,63,3533,2,53,532,532};
     * 求所有元素和。
     * 输出所有奇数下标元素。如：array[1]
     * 输出所有元素中，值为奇数的。
     * 将所有元素乘二。
     * 将所有元素加到第一个元素中。
     * 将奇数位置元素存到B数组中
     * 偶数元素存到C数组中
     * 分别逆序输出B数组和C数组
     */
    public static void demo5() {
        int[] array = {2, 432, 5221, 235, 2, 5352, 1, 53, 5, 3, 5364, 2, 2, 63, 3533, 2, 53, 532, 532};
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
        for (int i = 1; i < array.length; i += 2) {
            System.out.print(array[i] + " ");
        }

        for (int i : array) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * 2;
        }
        System.out.println(Arrays.toString(array));

        //偶数数组长度
        int evenLength = (array.length + 1) / 2;
        int oddLength = array.length - evenLength;
        int[] evenArry = new int[evenLength];
        int[] oddArry = new int[oddLength];
        int evenIndex = 0;
        int oddIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                evenArry[evenIndex] = array[i];
                evenIndex++;
            } else {
                oddArry[oddIndex] = array[i];
                oddIndex++;
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("奇数下表数组：" + Arrays.toString(oddArry));
        System.out.println("偶数下标数组：" + Arrays.toString(evenArry));

        //分别逆序输出B数组和C数组


    }

    /**
     * 从键盘接受10个整数保存在数组中，将10个数中最大的与第一个元素交换，最小的与最后一个元素交换，
     * 其余元素位置不变，输出数组元素的值
     */
    public static void demo6() {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("请输入第" + (i + 1) + "个整数：");
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(arr));

        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }

        System.out.println("最小值所在的索引是：" + minIndex);
        System.out.println("最大值所在的索引是：" + maxIndex);
        
        //特殊情况第一个是最小值，最后一个是最大值，故需要判断
        if (0 != maxIndex) {
            int temp;
            temp = arr[0];
            arr[0] = arr[maxIndex];
            arr[maxIndex] = temp;
        }

        if ((arr.length - 1) != minIndex) {
            int temp1 = arr[arr.length - 1];
            arr[arr.length - 1] = arr[minIndex];
            arr[minIndex] = temp1;
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 熟练创建方法以及调用方法
     */


    /**
     * 熟练使用方法形式参数以及返回值的问题
     */

}
