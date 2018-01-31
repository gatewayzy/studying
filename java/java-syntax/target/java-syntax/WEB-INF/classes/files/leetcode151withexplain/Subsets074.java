package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 * 本题题意：给出一个数组，里面没有重复的元素，然后给出所有元素的组合。
 * 
 *  If S = [1,2,3], a solution is:
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
	
	本题和60题的思路都是一样的，通过深度遍历的方式获取结果集。包含元素和不包含元素。
 *
 */
public class Subsets074 {
	
	
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		//特殊处理
        if(S.length == 0){
            return new ArrayList<ArrayList<Integer>>();
        }
 
        //排序
        sSort(S);
        
        //传统的思路  结果集和临时结果   然后递归调用
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tempResult = new ArrayList<Integer>();
        return generateResults(results,tempResult,S,0);
    }
    
    
	//对数组进行排序 
    public void sSort(int[] S){
        int length = S.length;
        for(int i = 0; i < length-1; i++){
            for(int j = i+1; j < length ; j++){
                if(S[j] < S[i]){
                    int temp = S[i];
                    S[i] = S[j];
                    S[j] = temp;
                }
            }
        }
        
        
    }
    
 
    public ArrayList<ArrayList<Integer>> generateResults(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> tempResult,int[] num,int n){
        //边界条件
        if(n == num.length){
            ArrayList<Integer> currentResult = new ArrayList(tempResult);
            results.add(0,currentResult);
            return null;
        }
        
        //加入该元素
        tempResult.add(num[n]);
        generateResults(results, tempResult,num,n+1);
        //不要该元素
        tempResult.remove(tempResult.size()-1);
        generateResults(results, tempResult,num,n+1);

        return results;
    } 
}
