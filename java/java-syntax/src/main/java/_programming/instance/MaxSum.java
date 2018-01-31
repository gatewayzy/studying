package _programming.instance;
import java.util.Scanner;

/**
 * 网易人工智能实习生笔试 <br>
 * 输入：查找4*4的数组中四个方向连续2个数字最大和 <br>
 * 输入4 2 <br>
 * 87 98 79 61<br>
 * 10 27 95 70 <br>
 * 20 64 73 29 <br>
 * 71 65 15 0 <br>
 * 输出 193
 * 
 * 输入<br>
 * 3 3<br>
 * 1 2 7<br>
 * 4 8 5<br>
 * 9 6 7<br>
 * 输出 24
 * 
 * @author dell
 *
 */
public class MaxSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = 0;
		int d = 0;
		n = scanner.nextInt();
		d = scanner.nextInt();

		// read
		int[][] mtr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mtr[i][j] = scanner.nextInt();
				// System.out.println(i + " " + j +" "+ mtr[i][j]);
			}
		}

		// select max
		int max = 0;
		int tmp = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				// hor
				if ((j + (d - 1)) < n) {
					tmp = 0;
					for (int k = j; k < j + d; k++) {
						tmp += mtr[i][k];
						// System.out.println(tmp);
					}
					if (tmp > max) {
						max = tmp;
					}
				}

				// ver
				if ((i + (d - 1)) < n) {
					tmp = 0;
					for (int k = i; k < i + d; k++) {
						tmp += mtr[k][j];
					}
					if (tmp > max) {
						max = tmp;
					}
				}

				// left top
				if ((i + d - 1) < n && (j + (d - 1)) < n) {
					tmp = 0;
					for (int ii = i, jj = j; ii < i + d; ii++, jj++) {
						tmp += mtr[ii][jj];
					}
					if (tmp > max) {
						max = tmp;
					}
				}

				// right top
				if ((i - (d - 1)) >= 0 && (j + (d - 1)) < n) {
					tmp = 0;
					for (int ii = i, jj = j; ii > i - d; ii--, jj++) {
						tmp += mtr[ii][jj];
					}
					if (tmp > max) {
						max = tmp;
					}
				}

			}
		}
		// print result
		System.out.println(max);

		scanner.close();
	}

}
