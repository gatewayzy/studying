package _programming.leetcode151withexplain;

/**
 * 本题是从一个数组中找到单独出现的一个数
 * 
 * 本题解题思路：通过抑或的方式，找到特别的那个数。两个相同的数抑或就是0.
 *
 */
public class SingleNumber015 {
	public int singleNumber(int[] A) {
        if(A.length == 1){
            return A[0];
        }
        
       //循环做抑或操作
       int answer = A[0] ^ A[1];
       for(int i = 2; i < A.length; i++){
           answer = answer ^ A[i];
       } 
       
       return answer;
    }
}
