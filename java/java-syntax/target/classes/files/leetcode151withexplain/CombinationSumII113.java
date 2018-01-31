package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 本题题意：给出一个数组，给出一个目标值，找出数组中所有的组合情况，使得其和等于目标值
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
	A solution set is: 
	[1, 7] 
	[1, 2, 5] 
	[2, 6] 
	[1, 1, 6] 
	
	解题思路：通过深度优先遍历就可以了。本题中考虑到了重复的情况，非常的巧妙
 *
 *
 */
public class CombinationSumII113 {
	
	 public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target){
		//进行排序
	    Arrays.sort(num);
	    //结果集和临时结果   深度遍历
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
	    ArrayList<Integer> path = new ArrayList<Integer>();  
        comb(num,0,0,target,res,path);  
        return res;  
	 }

	 /**
	  * 递归调用过程
	  * @param candidates 给定的数组
	  * @param index 目前遍历的index
	  * @param sum  当前和
	  * @param target 目标值
	  * @param res 结果集
	  * @param path  一个结果
	  */
	 public void comb(int[] candidates, int index, int sum, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path){  
	     //结果超标
		 if(sum > target) return;  
	     
		 //结果正好
	     if(sum == target){
	    	//别忘了是new
	     	res.add(new ArrayList(path));
	     	return;
	     }  
	     
	     //从当前位置开始遍历到结束
	     for(int i= index; i < candidates.length;i++){  
	    	 //加上当前值
	         path.add(candidates[i]);
	         //下一轮循环
	         comb(candidates,i+1,sum+candidates[i],target,res,path);
	         //不考虑当前节点
	         path.remove(path.size()-1);
	         //如果出现相同的元素，直接跳过（去重考虑）
	         while(i < candidates.length-1 && candidates[i]==candidates[i+1])i++;  
	     }  
	  } 
}
