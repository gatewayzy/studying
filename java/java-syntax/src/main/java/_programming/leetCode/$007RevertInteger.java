package _programming.leetCode;

/*
 * 本题题意：给出一个整数，反转这个整数
 *  Example1: x = 123, return 321
	Example2: x = -123, return -321
 * 	解题思路：通过取余数就能知道最后的数字是什么，然后依次乘以10加刚获取的末尾元素。然后别忘了最后情况的处理。
 */

/**
 * easy
 * 
 *
 */
public class $007RevertInteger {
	public static void main(String args[]) {
		int r = 3;
		//r = -123;
		//r = 123;
		//r= 1534236469;
		System.out.println(new Solution$007RevertInteger().reverse(r));
	}

}

/**
 * 将每个数字求余数然后生成新数字
 *
 */
class Solution$007RevertInteger {
	public int reverse(int x) {
		/***/
		long ret =0;
		
		while(x!=0){
			int tmp = x%10;
			ret = ret*10 +tmp ;
			x = x/10;
			
			if(ret>Integer.MAX_VALUE ||ret<Integer.MIN_VALUE){
				return 0;
			}
		}
		
		
		return (int)ret;
		/***/
	}
}