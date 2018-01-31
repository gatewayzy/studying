/**
 * 
 */
package _programming.instance;

/**
 * <b>问题</b>：n的阶乘结果中，末尾的0的个数<br>
 * <b>解决</b>：阶乘因子的每个数进行质数分解，统计因子5的个数和2的个数，由于阶乘中2的个数很多，所以只统计5的个数即可
 * <br> 来自滴滴
 * @author dell
 *
 */
public class CountZeroInFactorial {

	public static void main(String[] args) {
		System.out.println("计算阶乘的结尾0的个数");
		int i = 20;
		for (int n = 0; n <= i; n++) {
			doCount(n);
		}
	}

	static void doCount(int n) {
		int nBak = n;
		int count = 0;
		if (n >= 5) {
			for (int i = 5; i <= n; i++) {
				int j = i;
				while (true) {
					if (j % 5 == 0) {
						count++;
						j = j / 5;
						continue;
					} else {
						break;
					}
				}
			}
		}
		System.out.println(nBak + "!: " + count);
	}

}
