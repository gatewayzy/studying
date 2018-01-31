package _programming.leetcode151withexplain;

/**
 *  本题题意：有n阶的楼梯，每次可以走一步或者两步，问走完n阶楼梯有多少种方式。
 *
 *	解题思路：其实就是斐波那契数列  因为最后一个阶梯要不就是一步就到  要不就是两步就到  那么次数肯定就是两种情况的和 
 */
public class ClimbingStairs082 {
	
	public int climbStairs(int n){
        
        if(n == 0){
            return 0;
        }
        
        if(n == 1){
            return 1;
        }
        
        if(n == 2){
        	return 2;
        }
        
        int[] num = new int[n+1];
    	num[0] = 0;
    	num[1] = 1;
    	num[2] = 2;
    	for(int i = 3; i <= n; i++){
    		//递推公式
    		num[i] = num[i-1] + num[i-2];
    	}
        
        return num[n];
        
    }
}
