package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 * 本题题意：Pascals三角形。给出numRows，绘制出三角形
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.

	For example, given numRows = 5,
	Return
	
	[
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	]
	
	本题解题思路：
	一行一行的遍历，第一个和最后一个元素都是1.然后每一个元素都是上一行中相应元素的和。
	
 *
 */
public class PascalsTriangle033 {

	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		
		//用于存储结果 
        ArrayList<ArrayList<Integer>> answers = new ArrayList<ArrayList<Integer>>();
        
        if(numRows == 0){
            return answers;
        }
        
        //一行一行的遍历    每一行的数据总数就是i  然后每一行的第一个和最后一个元素都是1  然后其他位置的元素都等于上一行中左右两个元素的和。
        for(int i = 0; i < numRows; i++){
            ArrayList<Integer> currentAnswer = new ArrayList<Integer>();
            if(i == 0){
                currentAnswer.add(1);
                answers.add(currentAnswer);
            }else{
                currentAnswer.add(1);
                ArrayList<Integer> preAnswer = answers.get(i-1);
                for(int j = 0; j < (preAnswer.size()-1); j++){
                    int tempAdd = preAnswer.get(j)+preAnswer.get(j+1);
                    currentAnswer.add(tempAdd);
                }
                currentAnswer.add(1);
                answers.add(currentAnswer);
            }
        }
        
        return answers;
    
    }
}
