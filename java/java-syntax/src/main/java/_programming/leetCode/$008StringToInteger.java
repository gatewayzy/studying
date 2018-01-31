package _programming.leetCode;

/*
 * 题目大意：将一个字符串转换为数组，考虑行首空格，正负号，超出整数范围的记为最值，有非数字字符出现则完整
 */

/**
 * medium
 * 
 *
 */
public class $008StringToInteger {
	public static void main(String args[]) {
		String r = " -1a";
		r = " 0000";
		// r = " -1546";
		// r = " +1546";
		r = "   +0 123";
		r= "9223372036854775809";
		r="-2147483648";
		System.out.println(new Solution$008StringToInteger().myAtoi(r));
	}

}

/**
 * 将每个char取出乘10生成新数字
 *
 */
class Solution$008StringToInteger {
	public int myAtoi(String str) {
		/***/
		// special
		if (str == null || str.isEmpty()) {
			return 0;
		}
		long ret = 0;
		boolean isNegtive = false;
		// blank space
		while (str.startsWith(" ")) {
			str = str.replaceFirst(" ", "");
		}

		// +-
		if (str.charAt(0) == '+' || str.charAt(0) == '-') {
			isNegtive = str.charAt(0) == '-';
			str = str.substring(1);
		}
		// digit
		for (int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			if (tmp < '0' || tmp > '9') {
				break;
			}
			ret = ret * 10 + tmp - '0';
			if (ret>Integer.MAX_VALUE) {
				return isNegtive? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
		}

		if (isNegtive) {
			ret = -1* ret;
		}

		return (int) ret;
		/***/
	}
}