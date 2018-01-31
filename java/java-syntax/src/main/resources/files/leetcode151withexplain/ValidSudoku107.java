package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 本题题意：给出一个数独  只有部分数据  判断现在填写的数据是否有误
 * 
 * 解题思路：通过巧妙的数据结构，便可以快速的找到是否存在一些重复的元素。在计算区域的时候（(i/3) * 3） + (j/3)
 *
 */
public class ValidSudoku107 {
	
 	public boolean isValidSudoku(char[][] board) {
 		
 		//用于记录行  列  区域的数值  看是否有重复的数字
 		//arraylist中存储的都是hashmap，每一个hashmap记录的是每一个数字出现与否
        ArrayList<HashMap<Integer, Integer>> row_list_map = new ArrayList<HashMap<Integer, Integer>>();
        ArrayList<HashMap<Integer, Integer>> col_list_map = new ArrayList<HashMap<Integer, Integer>>();
        ArrayList<HashMap<Integer, Integer>> grid_list_map = new ArrayList<HashMap<Integer, Integer>>();
        
        //初始化这三个列表
        for(int i=0 ;i<9; i++){
            HashMap<Integer, Integer> tmp = new HashMap<Integer, Integer>();
            row_list_map.add(tmp);
            tmp = new HashMap<Integer, Integer>();
            col_list_map.add(tmp);
            tmp = new HashMap<Integer, Integer>();
            grid_list_map.add(tmp);
        }   
   
        //挨个行和列遍历
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
            	//如果是。那么就跳跃过去
                if(board[i][j] == '.')
                    continue;

                //如果改行中已经包含了这个元素  那么就是错误的
                if(row_list_map.get(i).containsKey(board[i][j]-'0')){
                    return false;
                //否则就加入这个元素进去
                }else{
                    row_list_map.get(i).put(board[i][j]-'0', 1);
                }
               
                if(col_list_map.get(j).containsKey(board[i][j]-'0')){
                    return false;
                }else{
                    col_list_map.get(j).put(board[i][j]-'0', 1);
                }
               
                //计算出所在的区域
                int index = ((i/3) * 3) + (j/3);
                if(grid_list_map.get(index).containsKey(board[i][j]-'0')){
                    return false;
                }else{
                    grid_list_map.get(index).put(board[i][j]-'0', 1);
                }
            }
        }
       
        return true;
    }
}
