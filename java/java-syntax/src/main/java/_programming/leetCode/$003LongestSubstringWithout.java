package _programming.leetCode;

/*
 * 本题题意：给出一个字符串，找到该字符串中包含有非重复字符的最长子串长度。
 * 
 *	For example,  "abcabcbb" is "abc", which the length is 3. 
 *	For "bbbbb" the longest substring is "b", with the length of 1.
 *  Given "pwwkew", the answer is "wke", with the length of 3.
 *	解题思路：通过一个map记录住每一个字符的位置，用idx记录基准位置，也就是当前位置和idx位置之间没有重复元素。
 *	对于每一个元素，如果之前已经出现过一次，如果上次的位置大于idx，那么就要更新idx，然后求出范围值。求出最新的answer就可以了。
 */
/**
 * medium
 * 
 * @author dell
 *
 */
public class $003LongestSubstringWithout {
	public static void main(String[] args) {
		String s = "abca";
		//s = "bbbbb";
		//s = "pwwkew";
		s = "p";
		System.out.println(new Solution$003LongestSubstringWithout().lengthOfLongestSubstring(s));
	}
}

/**
 * 1. 使用hashmap是否含有字符串会产生大量的子串 <br>
 * 2. 使用char会比较好，使用一个char的标志数组，进行二重循环判定
 *
 */
class Solution$003LongestSubstringWithout {
	public int lengthOfLongestSubstring(String s) {

		/***/

		// special
		if (s == null || s.isEmpty()) {
			return 0;
		}
		int len = s.length();

		char[] chars = s.toCharArray();

		int[] flag = new int[256];// flag for every char

		int ret = 0;
		int count = 0;
		for (int i = 0; i < len; i++) {
			count = 0;
			// count string
			for (int j = i; j < len; j++) {
				if (flag[chars[j]] < 0) {
					break;
				}
				count++;
				ret = ret > count ? ret : count;
				flag[chars[j]] = -1;
			}
			// clear flag
			for (int j = 0; j < 256; j++) {
				flag[j] = 0;
			}
		}

		return ret;
		/***/

	}
}
