package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 * 本题题意：给出一个数组，给出所有的排列情况
 * For example,
	[1,2,3] have the following permutations:
	[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	
	解题思路：和106是一样的
 *
 */
public class Permutations107 {
	 	public ArrayList<ArrayList<Integer>> permute(int[] num) {
	        return generatePermute(num, num.length-1);
	    }
	    
	    public ArrayList<ArrayList<Integer>> generatePermute(int[] num, int currentPosition){
	        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
	        
	        if(currentPosition == 0){
	            ArrayList<Integer> currentResult = new ArrayList<Integer>();
	            currentResult.add(num[0]);
	            results.add(currentResult);
	            return results;
	        }
	        
	        ArrayList<ArrayList<Integer>> nextResults = generatePermute(num, currentPosition-1);
	        for(ArrayList<Integer> intList : nextResults){
	            int size = intList.size();
	            for(int i = 0; i <= size; i++){
	                intList.add(i,num[currentPosition]);
	                results.add(new ArrayList<Integer>(intList));
	                intList.remove(i);
	            }
	        }
	        
	        return results;
	    }
}
