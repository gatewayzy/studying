package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 *  本题题意：给出一个数组，数组代表一个非负整数，然后为这个整数加一，返回结果数组
 *  
 *  解题思路: 通过一个Arraylist来存储数组中的每一位，别忘了最后的进位处理。
 *
 */
public class PlusOne085 {
	
		public int[] plusOne(int[] digits) {
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        //记录进位是多少
	        int plusNum = 0;
	        int digitSize = digits.length;
	        
	        //从数组的最后位置开始遍历这个整数数组
	        for(int i = 0; i < digitSize; i++){
	            int currentNum = digits[digitSize-1-i];
	            if(i == 0){
	                currentNum += 1;
	            }
	            
	            //如果>= 10
	            if((currentNum + plusNum) >= 10){
	            	//去的余数和进位
	                currentNum = (currentNum + plusNum) % 10;
	                plusNum = 1;
	            }else{
	                currentNum = currentNum + plusNum;
	                plusNum = 0;
	            }
	            
	            //增加到结果
	            result.add(0,currentNum);
	        }
	        
	        //别忘了最后一位
	        if(plusNum == 1){
	            result.add(0,1);
	        }
	        
	        //为了越界问题，先用arraylist来存储数据，然后用数组来存储
	        int answerSize = result.size();
	        int[] answer = new int[answerSize];
	        for(int j = 0; j < answerSize; j++){
	            answer[j] = result.get(j);
	        }
	        
	        return answer;
	        
	    }
}
