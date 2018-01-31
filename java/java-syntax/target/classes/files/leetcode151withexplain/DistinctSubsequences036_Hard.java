package _programming.leetcode151withexplain;

/**
 * 本题题意：给出两个字符串S和T，判断S中子序列T的个数
 * 
 * http://blog.csdn.net/worldwindjp/article/details/19770281
 * 
 *  Here is an example:
	S = "rabbbit", T = "rabbit"
	Return 3.
	
	一般思路：通过深度优先遍历，即一个字符一个字符的作为一个层次，然后每一个层次是由一个字符出现的次数决定每一层的可能结果多少。
	
	本题的解题思路：
	通过dp的方式实现。加入S【i】 = T[j]相等，那么dp[i][j] = 左上角一列的加和。如果不相等，那么就等于零。
	
	本题需要考虑好f[i][j]所代表的是什么。
 *
 */
public class DistinctSubsequences036_Hard {

	public int numDistinct(String S, String T) {
		 int sLength = S.length();
		 int tLength = T.length();
		 if(sLength == 0 || tLength == 0){
			 return 0;
		 }
		 
		 int[][] f = new int[sLength+1][tLength+1];
		 f[0][0] = 1;
		 for(int i = 1; i <= sLength; i++){
			 f[i][0] = 0; 
		 }
		 
		 for(int j = 1; j <= tLength; j++){
			 f[0][j] = 0;
		 }
		 
		 for(int q = 1; q <= sLength; q++){
			 for(int p = 1; p <= tLength; p++){
				 if(S.substring(q-1,q).equals(T.substring(p-1,p))){
					 f[q][p] = 0;
					 for(int k = 0; k < q; k++){
						 f[q][p] += f[k][p-1];
					 }
					 
				 }else{
					 f[q][p] = 0;
				 }
			 }
		 }
		 
		 int sum = 0;
		 for(int w = 0; w <= sLength; w++){
			 sum += f[w][tLength];
		 }
		 
		 return sum;
	}
}
