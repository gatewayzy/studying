package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  本题题意：给出一个数组  然后求出其左右的子集   给出的数组中有重复的元素  这个比较特殊
 *  
 *  If S = [1,2,2], a solution is:
	[
	  [2],
	  [1],
	  [1,2,2],
	  [2,2],
	  [1,2],
	  []
	]
	
	本题的解题思路：深度优先遍历   当考虑当前元素的时候以及不考虑当前元素的时候
	
	边界条件就是：已经到数组最后的位置而且结果集中不包含当前元素
 *
 */
public class SubsetsII060 {
	
	   public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
	       if(num.length == 0){
	           return new ArrayList<ArrayList<Integer>>();
	       }  
	       
	       //先对数组进行排序
	       Arrays.sort(num);
	       ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
	       ArrayList<Integer> tempResult = new ArrayList<Integer>();
	       return generateResults(results, tempResult,num,0);
	       
	    }
	    
	    //函数参数还是老套路  总结果和临时结果
	    public ArrayList<ArrayList<Integer>> generateResults(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> tempResult,int[] num,int n){
	        
	    	//边界条件  如果当前已经到了数组的最后位置   而且结果集中不包含该临时结果
	    	//包含不包含  可以这样判断  contains
	        if(n == num.length && !results.contains(tempResult)){
	            ArrayList<Integer> currentResult = new ArrayList(tempResult);
	            results.add(currentResult);
	            return null;
	        }else if(n == num.length){
	            return null;
	        }
	        
	        //结果中加上当前元素
	        tempResult.add(num[n]);
	        generateResults(results, tempResult,num,n+1);
	        //结果中不包含当前元素
	        tempResult.remove(tempResult.size()-1);
	        generateResults(results, tempResult,num,n+1);

	        //返回结果
	        return results;
	    } 
}
