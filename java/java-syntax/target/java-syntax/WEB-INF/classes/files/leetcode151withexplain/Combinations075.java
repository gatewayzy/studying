package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 *	 本题题意：给出n和k两个数，组合出从1-n的所有k的数的组合。
 *	If n = 4 and k = 2, a solution is:
	[
	  [2,4],
	  [3,4],
	  [2,3],
	  [1,2],
	  [1,3],
	  [1,4],
	]
 *
 */
public class Combinations075 {
	
	 	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
	       ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
	       ArrayList<Integer> tempResult = new ArrayList<Integer>();
	       //传统的解题思路  由结果集和临时结果构成
	       getCombineResult(results, tempResult,n, 1, 1,k);
	       return results;
	    }
	    
	 	/**
	 	 * 参数解释
	 	 * @param results  结果集
	 	 * @param tempResult  临时结果
	 	 * @param n 数据最大值 
	 	 * @param currentN  当前到了第几个数
	 	 * @param currentK  当前有了几个数
	 	 * @param k 可以放多少数
	 	 */
	    public void getCombineResult(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> tempResult,int n, int currentN, int currentK,int k){
	        //当前数目没有达到要求的数字多少  而且后面不再有其他数字
	        if(currentK != (k+1) && currentN > n){
	            return;
	        }
	        
	        //当前数字凑够了  而且 已经到了最后的位置  加入到结果集中
	        if(currentK == (k+1) || currentN > n){
	            results.add(new ArrayList(tempResult));
	            return;
	        }
	        
	        //考虑当前结果  不考虑当前节点 和考虑当前节点
	        tempResult.add(currentN);
	        getCombineResult(results, tempResult,n, currentN+1, currentK+1,k);
	        tempResult.remove(tempResult.size()-1);
	        getCombineResult(results, tempResult,n, currentN+1, currentK,k);
	        
	    }
}
