package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 *  本题题意：给出格雷编码，所谓的格雷编码就是相邻的两个二进制编码只是相差一位。
 *  
 *   For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

		00 - 0
		01 - 1
		11 - 3
		10 - 2
		
	本题题意：格雷编码的实现方式就是   i xor i/2
	
	注意nSize的求法  1 << n就等于 1 * 2^n
 *
 */
public class GrayCode062 {
	
	public ArrayList<Integer> grayCode(int n) {
        
		ArrayList<Integer> result = new ArrayList<Integer>();
   	
   	    //left move to know n has how many binary results 3 -> 8    0001 << 3  1000 = 8
   	    //给操作就等于1 * 2^n次方
		int nSize = 1 << n;  
   	    
        for (int i = 0; i < nSize; ++i)  
        {  
       	 	//convert binary to gray code i xor (i >> 1)
        	int a = i >> 1;
        	int b = a ^ i;
       	 
            result.add(b);  
        }  
        return result;  
   }
}
