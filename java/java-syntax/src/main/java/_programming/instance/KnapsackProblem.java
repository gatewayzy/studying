package _programming.instance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 背包问题 Knapsack Problem<br>
 * use 'ctrl z' to stop input<br>
 * 背包问题：用一个容量m的背包装货物，每个货物不同的重量weight和价值value，求解装货最大价值。<br>
 * 每个货物至多装一个就是0-1背包<br>
 * 每个货物可以装count(i)个就是有界背包<br>
 * 每个货物可以装无限多个就是完全背包问题<br>
 * 
 * @author dell
 *
 */
public class KnapsackProblem {

	/**
	 * 5 100 77 92 22 22 29 87 50 46 99 90 <br/>
	 * 8 200 79 83 58 14 86 54 11 79 28 72 65 52 15 48 68 62<br/>
	 * 133 334
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 判断是否有输入
		while (scanner.hasNext()) {
			int n = scanner.nextInt(); // n个货物
			int m = scanner.nextInt(); // m的背包

			// 读取各个货物的weight和value
			int[] w = new int[n];
			int[] v = new int[n];
			for (int i = 0; i < n; i++) {
				w[i] = scanner.nextInt();
				v[i] = scanner.nextInt();
			}

			solution(m, w, v);

		}
		scanner.close();
	}

	/**
	 * 使用动态规划求解背包问题
	 * 
	 * @param m
	 * @param w
	 * @param v
	 */
	public static void solution(int m, int[] w, int[] v) {
		System.out.println(Arrays.toString(w));
		System.out.println(Arrays.toString(v));
		int n = w.length;
		int[][] dp = new int[n + 1][m + 1];
		// 初始化，数组元素相当于对象的成员变量，所以默认会自动初始化
		// 进行dp推算
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (j >= w[i-1]) { // 如果能够装下当前这个，就是转移方程：max（添加、非添加时对应的状态）
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i-1]);
				}else{
					// 装不当前这个，就是前i-1的value
					dp[i][j] = dp[i-1][j]; 
				}
			}
		}
		System.out.println(dp[n][m]);

	}
}
