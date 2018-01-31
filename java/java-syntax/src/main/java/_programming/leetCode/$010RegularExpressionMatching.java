package _programming.leetCode;

/*  本题题意：常规字符串匹配   .代表任意一个字符，*代表前面的元素重复0次或者其他次数
 * 
 *  Some examples:
	isMatch("aa","a") → false
	isMatch("aa","aa") → true
	isMatch("aaa","aa") → false
	isMatch("aa", "a*") → true
	isMatch("aa", ".*") → true
	isMatch("ab", ".*") → true
	isMatch("aab", "c*a*b") → true
 * 
 *  解题思路：采用递归调用的思想；遍历p，先看看第二个字符是不是*，如果不是*的话，那么就一定要判断前面的第一个字符是不是可以匹配的，如果前面字符匹配了，那么就看看那后面的字符串是不是匹配的；
 *  如果是*,那么就要判断*号代表前面的字符出现几次。如果前面的不断匹配，那么就要继续往后遍历s，当前面不匹配的时候，那么就要看看两个字符串后面的部分是不是匹配。
 */

/**
 * hard
 * 
 *
 */
public class $010RegularExpressionMatching {
	public static void main(String args[]) {
		int x = 123;
		//x = 121;
		//x = -123;
		//x = 8123;
		//x = 12321;
		System.out.println(new Solution$009PalindromNumber().isPalindrome(x));
	}

}

class Solution$010RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		/***/
		
		
		return true;
		/***/
	}
}