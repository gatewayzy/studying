package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 本题题意：给出一个字符串，里面可能有重复的数字，在数组中找到三个数，使得三个数的和为0.结果中的元素按递增顺序排列，结果集中不能有重复。
 * 
    For example, given array S = {-1 0 1 2 -1 -4},
    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 *
 *	解题思路：遍历数组中的每一个元素，如果不是第一个元素，也可以去重；对于后面的元素，同样可以按排序后头尾遍历找两个元素；找这两个元素的过程中可以去重。因为后面凡是考虑过的元素就没必要再考虑了。
 */
public class ThreeSum135 {
	
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
	  
		//用于记录结果
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
	    //特殊情况处理
	    if (num.length == 0) return ret;
	    //数组进行排序
	    Arrays.sort(num);
	    
	    int numLength = num.length;
	    //排序之后从前面开始遍历
	    for(int i = 0; i < numLength; i++){
	        //如果不是第一个元素，而且出现了重复，那么就跳过
	        if (i != 0 && num[i] == num[i-1]){
	            continue;
	        }
	        
	        //在该元素后面找到两个数字的和为指定元素
	        int front = i + 1;
	        int back = numLength - 1;
	        //当front小于back的时候  依次判断当前的元素是否是合适的
	        while (front < back)
	        {
	            int sum = num[i] + num[front] + num[back];
	            
	            //如果和大于0  后面往前走
	            if (sum > 0)
	            {
	                --back;
	            }
	            else if (sum < 0)
	            {
	                ++front;
	            }
	            //如果不是后面i+1到n里面的第一个元素，而且和前面的数值一样，那么可以跳过去一个
	            else if (front != (i + 1) && num[front] == num[front - 1])
	            {
	                ++front;
	            }
	            //如果不是后面元素中的最后一个元素，如果该元素和后面的元素一样，那么就跳过一个元素
	            else if (back != (numLength - 1) && num[back] == num[back + 1])
	            {
	                --back;
	            }
	            
	            else
	            {
	            	ArrayList<Integer> result = new ArrayList<Integer>();
	                
	                // Already sorted.
	                result.add(num[i]);
	                result.add(num[front]);
	                result.add(num[back]);
	                
	                ret.add(result);
	                
	                ++front;
	                --back;
	            }
	        }
	    }
	    
	    return ret;
  }
}
