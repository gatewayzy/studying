package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 本题题意：给出一个数组和一个目标值，组合数组中的数字，其和要为target。可以重复选择数组中的数字
 * For example, given candidate set 2,3,6,7 and target 7, 
	A solution set is: 
	[7] 
	[2, 2, 3] 
 *
 * 解题思路：采用深度优先遍历的方式，递归调用，只是当前元素可以考虑很多次。
 */
public class CombinationSum114 {
	 	
	    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
	       ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
	       ArrayList<Integer> tempResult = new ArrayList<Integer>();
	       Arrays.sort(candidates);
	       //对数组进行排序  然后采用传统的dfs思想  结果集和结果  然后递归遍历获取结果
	       getResults(results,tempResult,candidates,target,0);
	       return results;
	    }
	    
	    /**
	     * DFS调用
	     * @param results  结果集
	     * @param tempResult  结果
	     * @param candidates 候选集
	     * @param target 目标值
	     * @param currentPosition 当前位置
	     */
	    public void getResults(ArrayList<ArrayList<Integer>> results,ArrayList<Integer> tempResult,int[] candidates,int target, int currentPosition){
	        int cLength = candidates.length;
	        //当前位置超标
	        if(currentPosition >= cLength){
	            return;
	        }
	        
	        //获取当前结果的和  如果大于目标值  那么返回
	        int currentSum = getSum(tempResult);
	        if(currentSum > target){
	            return;
	        }
	        
	        //当前和与目标值相等
	        if(currentSum == target){
	            results.add(new ArrayList(tempResult));
	            return;
	        }
	        
	        //结果中增加这个结果
	        tempResult.add(candidates[currentPosition]);
	        //递归遍历 currentPosition不变化
	        getResults(results,tempResult,candidates,target,currentPosition);
	        //不考虑当前借宿  currentPosition++
	        tempResult.remove(tempResult.size()-1);
	        getResults(results,tempResult,candidates,target,currentPosition+1);
	        
	    }
	    
	    public int getSum(ArrayList<Integer> tempResult){
	        int tR = tempResult.size();
	        int sum = 0;
	        for(int i = 0; i < tR; i++){
	            sum += tempResult.get(i);
	        }
	        return sum;
	    }
}
