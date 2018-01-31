package _programming.leetcode151withexplain;

import java.util.HashMap;

/**
 * 本题题意：给出一个数组和目标值，从数组中找到两个值使得其和为目标值。返回两个下标位置。
 * 
 * 解题思路：通过一个map用来存储每一个位置仍需的数值target-num[i]以及当前的坐标i。如果出现了所需要的数值，那么结果就出现了。
 *
 */
public class TwoSum134 {
	
	public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;  
        
        //由于记录结果
        int[] ret = new int[2];
        
        //hashmap
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();  
          
        for(int i = 0; i < len; i++){
        	//也不用排序   遍历每一个元素  把该元素还需要的数值及本身的坐标放到map中
            if( !map.containsKey(numbers[i]) ){  
                map.put(target - numbers[i], i);        // save another number  
            }  
             
            //如果map中已经存在了  即找到了所需要的元素
            if( map.containsKey(numbers[i]) ){
            	//那么就生成了结果  
                int idx = map.get(numbers[i]);  
                if(idx < i){  
                    ret[0] = idx + 1;   // +1 for not zero-based  
                    ret[1] = i + 1;  
                }  
            }  
        }  
          
        return ret;  
    }
}
