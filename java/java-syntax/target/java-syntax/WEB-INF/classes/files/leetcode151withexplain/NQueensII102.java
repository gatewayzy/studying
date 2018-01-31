package _programming.leetcode151withexplain;

import classic.NQueensII;

/**
 * 本题题意：返回Nqueenes的结果多少
 * 
  * 这个是求出所有的数目  其实也可以求出所有的路径  只是非递归的方式实现的
 * 
 * 解题思路：思路就是通过一个数组记录住每一个queen应该放到的位置，然后不断的循环，知道没有当前可以放置的皇后（t < 0）.
 *
 */
public class NQueensII102 {
	

	public int[] position;
    public int totalNQueens(int n) {
        int sum = 0;
        if(n == 0) return sum;
       
        position = new int[n+1];
        
        position[1] = 0;
        int t = 1;
        while(t > 0){
        	//通过t来控制当前是放置的那个象棋
            position[t] += 1;
            //不断的往下摆放，知道找到合适的位置
            while(position[t] <= n && !place(t,n)){
                position[t]++;
            }
            
            //可以正确放置之后判断现在是否放置到最后一个棋子，如果不是，那么就放下一个。
            //如果找到的位置是最后一个位置   那么就要判断当前的皇后是否是最后一个皇后
            if(position[t] <= n){
                if(t == n){
                    sum++;
                //如果是 那么安置下一个皇后
                }else{
                    position[++t] = 0;
                }
            //也就是本行找不到适当的位置  那么就退到上一个皇后
            }else{
                t--;
            }
            
        }
        
        return sum;    
    }
    
    public boolean place(int ith,int n){
        for(int i = 1; i < ith; i++){
            if(position[ith] == position[i] || Math.abs(position[ith] - position[i]) == Math.abs(ith - i)){
                return false;
            }
        }
        return true;
    }
}
