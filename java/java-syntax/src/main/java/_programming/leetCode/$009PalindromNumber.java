package _programming.leetCode;

/*
 * 判断一个整数是否是回文，不能使用额外空间
 */

/**
 * easy
 * 
 *
 */
public class $009PalindromNumber {
	public static void main(String args[]) {
		int x = 123;
		x= 12;
		//x = 121;
		//x = -123;
		//x = 8123;
		//x = 12321;
		System.out.println(new Solution$009PalindromNumber().isPalindrome(x));
	}

}

/**
 * 计算一共有几个10倍，不断进行首尾相消
 *
 */
class Solution$009PalindromNumber {
	public boolean isPalindrome(int x) {
		/***/
		//special
		if (x<0) {
			return false;
		}else if (x<10) {
			return true;
		}
		// digit
		int base = 1;
		while(x/base >=10){
			base *= 10;
		}
		
		// test
		while(base >=10){
			if (x/base != x%10) {
				return false;
			}
			x = (x-x/base*base)/10;
			base /= 100;
		}
		
		return true;
		/***/
	}
}