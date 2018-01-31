package _programming.leetcode151withexplain;

import java.util.Arrays;

/**
 * 本题题意：给出一个数组和一个目标值，在数组中找到三个值，是的三个值的和最接近target。然会这个和。
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 *
 */
public class ThreeSumClosest136 {
	
	public int threeSumClosest(int[] num, int target) {
        int result = 0;
        Arrays.sort(num);
        int numLength = num.length-1;
        
        //初始化一个结果
        result = num[0]+num[numLength-1]+num[numLength];
        //遍历每一个元素作为开始元素
        for(int i = 0; i <= numLength; i++){
            int j = i+1;
            int k = numLength;
            //从后面的元素中找到两个元素  看能否找到结果
            while(j < k){
                int tempSum = num[i]+num[j]+num[k];
                if(tempSum == target){
                    return tempSum;
                }
                
                if(tempSum > target){
                    k--;
                }
                if(tempSum < target){
                    j++;
                }
                //找到最接近的
                if(Math.abs(tempSum-target) < Math.abs(result-target)){
                    result = tempSum;
                }
                
            }
            
        }
        
        return result;
    }
}
