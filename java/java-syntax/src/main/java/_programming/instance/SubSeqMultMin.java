package _programming.instance;

import java.util.Scanner;

/***
 * 给定序列如 3 6 2 1，进行全排列[6] [2] [1] [6,2]...求一个排列T中最小值*T中元素和的最大值，这里是[6]：6*6=36，大于[6,2]:2*(6+2)=16
 * 输入 3 6 2 1  最终输出是36，当然，先给第一个是序列长度n。
 * 解法1：全排列然后比较最大值（问题在于复杂度是n*n，超限）
 * 解法2：n*log(n)解法：对每个数，设定其为序列中最小值，向左右贪心扩充，求出其最大结果，所以是n*log(n)
 */
public class SubSeqMultMin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        scanner.close();

        // 对每个数，求出以他为最小值的最长序列的输出值
        int retMax = 0;
        int sum = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            sum = data[i];  // 设定当前值最小，可拓展的最大序列
            j = i;  // cursor
            while (j < n && data[j] >= data[i]) {  // 向后拓展，要求比base大
                if (j != i) sum += data[j];
                j++;
            }
            j = i;  // cursor reset
            while (j >= 0 && data[j] >= data[i]) {  // 向前拓展，要求比base大
                if (j != i) sum += data[j];
                j--;
            }
            retMax = Math.max(sum * data[i], retMax);
        }
        System.out.println(retMax);
    }

}
