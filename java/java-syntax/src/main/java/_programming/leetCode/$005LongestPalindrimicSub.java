package _programming.leetCode;

/*
 * 本题题意：求出给定字符串里面的最长回文子串
 * 解题思路：首先初始化，都是一个元素的时候，那么就是回文，然后再两个两个字符的判断，然后三个三个的判断，
 * 其实就和矩阵向右上角移动的感觉是一样的。
 * 然后通过一个范围变量记录住答案的范围。返回结果就行了。
 * Input: "babad"  Output: "bab"  Note: "aba" is also a valid answer.
 *  参考：[最长回文子串——Manacher 算法](https://segmentfault.com/a/1190000003914228)
 */

/**
 * meidum
 * 
 *
 */
public class $005LongestPalindrimicSub {
	public static void main(String args[]) {
		String s = "babad";
		s = "b";
		s = "bbbb";
		
		System.out.println(new Solution$005LongestPalindrimicSub().longestPalindrome(s));
	}

}

/**
 * 动态规划：用一个pal[i][j]存储s[i...j]是否是回文
 */
class Solution$005LongestPalindrimicSub {

	public String longestPalindrome(String s) {

		/***/
		int len = s.length();
		boolean[][] pal = new boolean[len][len];

		int maxLen = 0;
		String maxStr = "";

		for (int end = 0; end < len; end++) {

			int start = end;
			while (start >= 0) {
				// 对每个s[start...end]判断方法是首尾相等且中间是回文，中间是回文的方法是如果多余1个字符就需要是回文
				if (s.charAt(start)==s.charAt(end) && (end-start <=1 || pal[start+1][end-1])) {
					pal[start][end] = true;
					if (maxLen<end-start+1) {
						maxLen = end-start+1;
						maxStr = s.substring(start, end+1);
					}
				}
				start --;
			}

		}
		return maxStr;

		/***/
	}

}