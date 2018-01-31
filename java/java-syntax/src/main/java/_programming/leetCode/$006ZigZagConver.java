package _programming.leetCode;

/*
 * 本题题意：给出一个字符串，该字符串会通过Z字形排列，然后给出Z字形排列的顺序读取结果。
 * 
 *  P   A   H   N
	A P L S I I G
	Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"
         
    n=4时的走法是：
 	0      6       12
 	1   5  7    11 13
 	2 4    8 10    14
 	3      9       15 
 */

/**
 * meidum
 * 
 *
 */
public class $006ZigZagConver {
	public static void main(String args[]) {
		String s = "PAYPALISHIRING";int r = 3;
		// s = "ABCDEF";r=3;
		// s = "AB";r=1
		System.out.println(new Solution$006ZigZagConver().convert(s, r));
	}

}

/** 解题思路：直接构造二维数组或者查找规律<br>
 * 查找规律时将示例中的0-5视为一个周期
 *
 */
class Solution$006ZigZagConver {
	public String convert(String s, int numRows) {
		/***/
		// special
		if (s == null || s.isEmpty() || numRows <= 0) {
			return "";
		}
		if (numRows == 1) {
			return s;
		}

		// construct
		int n = s.length();
		String ret = "";
		int step = 2 * (numRows - 1);

		for (int i = 0; i < numRows; i++) {
			for (int j = i; j < n; j += step) {//按周期处理
				ret += s.charAt(j);// 正常处理完整一个竖线
				if (i!=0 && i!= numRows-1) {// 添加中间一块
					int other = j+step-2*i; //这里需要和i，j，step都有关系，可以用方式求解关系
					if (other<n) {//需要确保长度足够输出
						ret += s.charAt(other);
					}
				}
			}

		}


		return ret;
		/***/
	}
}