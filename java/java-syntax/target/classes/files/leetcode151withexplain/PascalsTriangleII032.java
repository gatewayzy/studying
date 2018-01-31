package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 * 本题题意：给出rowIndex，返回对应行的数据。 
 *
 * 解题思路：本题的解题思路和33中的差不多，只是这次是通过维度为1的数组实现的，节省了空间.
 * 
 * 注意点:别忘了边界条件。
 */
public class PascalsTriangleII032 {
	
	
	public ArrayList<Integer> getRow(int rowIndex) {
        
		//用于存储结果
        ArrayList<Integer> answers = new ArrayList<Integer>();
        
        //deal special situation
        if(rowIndex == 0){
            answers.add(1);
            return answers;
        }
        
        if(rowIndex == 1){
            answers.add(1);
            answers.add(1);
            return answers;
        }
        
        //initialize values
        if(rowIndex >= 2){
            answers.add(1);
            answers.add(1);
        }
        
        //use one arry to put all numbers. f[x][y] = f[x-1][y] + f[x-1][y-1]
        //而且边界元素都是1
        for(int i = 2; i <= rowIndex; i++){
            for(int j = i; j > 0; j--){
                 if(j == i){
                     answers.add(1);
                 }else{
                     answers.set(j,answers.get(j)+answers.get(j-1));
                 }
            }
        }
        
        return answers;
        
    }
}
