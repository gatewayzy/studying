package _programming.leetcode151withexplain;

import java.util.HashMap;
import java.util.Map;

/**
 * 本题题意：给出数组中的一串数字，找到里面缺省的第一个正整数
 * 
 *  For example,
	Given [1,2,0] return 3,
	and [3,4,-1,1] return 2.
	Your algorithm should run in O(n) time and uses constant space.
 * 
 * 解题思路:先通过一次遍历获取最大值。
 * 然后从1开始遍历到最大值，看map是否存在就可以了。
 *
 */
public class FirstMissingPositive112_Done {
	
	public int firstMissingPositive(int[] A) {
        int minPositiveInt = Integer.MAX_VALUE;
        int maxPositiveInt = Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        //遍历数组中的每一个元素
        int aLength = A.length;
        for(int i = 0; i < aLength; i++){
            if(A[i] <= 0){
                continue;
            }else{
            	//获取当前出现的最小值
                minPositiveInt = min(A[i],minPositiveInt);
                //获取当前出现的最大值
                maxPositiveInt = max(A[i],maxPositiveInt);
                //压入到map中
                map.put(A[i],1);
            }
        }
        
        //从1开始遍历，一直到最大值，如果出现为空的，那么就是这个数字了
        for(int k = 1; k <= maxPositiveInt+1;k++){
            if(map.get(k) == null){
                return k;
            }
        }
        
        return 1;
    }
    
    public int max(int a, int b){
        if(a > b){
            return a;
        }else{
            return b;
        }
    }
    
    public int min(int a ,int b){
        if(a < b){
            return a;
        }else{
            return b;
        }
    }
    
    
    public int firstMissingPositive1(int[] A) {
    	// Note: The Solution object is instantiated only once and is reused by each test case.  
        int n  = A.length;
    	if(null == A || n < 1)                                                                                                                                     
            return 1;
    	
        int pos=0;  
        while(pos < n){
        	
        	//1、交换的元素是大于0的元素 2、交换的元素不在自己的位置上  3、元素值本身没有超过数组的长度，即有交换的位置  4、将要交换的地方的数据和当前的数据不相等  如果相等，那么就不用替换了
            if(A[pos] > 0 && A[pos] != pos+1 && A[pos] - 1 < n && A[pos] != A[A[pos]-1]){                                                                                                                                                  
                swap(A,pos,A[pos]-1);     
            }else{  
                ++pos;
            }
        }     
        
        for(int i=0;i<n;++i)  
        {     
            if(i+1 != A[i])  
                return i+1;                                                                                                                                    
        }
        
        return n+1;  
    }
    
    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
}
