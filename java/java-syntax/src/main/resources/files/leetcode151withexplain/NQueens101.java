package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;

/**
 * 本题题意： n皇后问题，给出所有可能的结果
 *
 * 解题思路：通过深度优先遍历的方式构建结果。通过一个数组position[]数组来记录每一个皇后的位置。当递归的边界条件满足的时候，获取结果。
 */
public class NQueens101 {
	
	//记录住第n个皇后放到的列  position[1] = 2：意思就是第一个皇后放在第二列
	public int[] position;
	
    public List<String[]> solveNQueens(int n) {
    	//用于存储结果
        List<String[]> answer = new ArrayList<String[]>();
        if(n == 0) return answer;
        //初始化数组
        position = new int[n+1];
        queen(answer,1,n);
        return answer;
    }
    
    public void queen(List<String[]> answer, int ith,int n){
    	//边界条件成立  获取结果
        if(ith > n && n > 0){
            getAnswer(answer);
            return;
        }
        
        //采用dfs的方式，每一层次都有n种可能
        for(int i = 1; i <= n; i++){
            position[ith] = i;
            if(place(ith)){
                queen(answer,ith+1,n);
            }
        }
    }
    
    //判别函数  判断是否可以放置到该位置  不在同一列   不在同一条线上
    public boolean place(int ith){
        for(int i = 1; i < ith; i++){
            if(position[ith] == position[i] || Math.abs(position[ith] - position[i]) ==  Math.abs(ith - i)){
                return false;
            }
        }
        return true;
    }
    
    //获取结果
    public void getAnswer(List<String[]> answer){
        int n = position.length-1;
        String[] result = new String[n];
        for(int i = 1; i <= n; i++){
           String currentS = "";
           int p = position[i];
           for(int j = 1; j <= n; j++){
               if(j == p){
                   currentS += "Q";
               }else{
                   currentS += ".";
               }
           }
           result[i-1] = currentS;
        }
        answer.add(result);
    }
}
