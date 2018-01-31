package _programming.instance;

import java.util.Scanner;

/**
 * 输入一串数字，计算策略分成两组（数字相对顺序不变），使得两组各自内部相邻之间数字差的绝对值之和最小。
 * 比如5个数：1 5 6 2 1，最好分成1 2 1和5 6，这样输出差的绝对值之和最小为1+1+1=3
 */
public class MinAbsChorus {
    static {
        System.out.println("5 1 5 6 2 1\n3"); // 556 121
    }

    static int maxn = 2000 + 5;
    static int[] v = new int[maxn];
    static int[][] dp = new int[maxn][maxn];
    static int n;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        n = cin.nextInt();
        v[0] = -1;
        for (int i = 1; i <= n; i++) v[i] = cin.nextInt();

        for (int i = 0; i < maxn; i++)
            for (int j = 0; j < maxn; j++)
                dp[i][j] = -1;

        System.out.println(solve(0, 0));
    }

    //使用动态规划，dp[i][j]表示A唱v[i], B唱v[j]的和最小。记忆化搜索
    static int solve(int la, int lb) {
        if (dp[la][lb] != -1) return dp[la][lb];

        int now = Math.max(la, lb) + 1;
        if (now == n + 1) return 0;

        return dp[la][lb] = Math.min(solve(now, lb) + (la > 0 ? Math.abs(v[now] - v[la]) : 0),
                solve(la, now) + (lb > 0 ? Math.abs(v[now] - v[lb]) : 0));
    }
}