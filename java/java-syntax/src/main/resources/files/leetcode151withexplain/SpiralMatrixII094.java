package _programming.leetcode151withexplain;

/**
 *	本题题意：给出n,构建一个二维矩阵，螺旋序列。
 *	For example,
	Given n = 3,
	
	You should return the following matrix:
	[
	 [ 1, 2, 3 ],
	 [ 8, 9, 4 ],
	 [ 7, 6, 5 ]
	]
	
	解题思路：通过设置边界，然后按螺旋顺序为矩阵赋值。
 *
 */
public class SpiralMatrixII094 {
	
	public int[][] generateMatrix(int n) {
		//结果矩阵
        int[][] answer = new int[n][n];
        if(n == 0) return answer;
        
        //开始行和结束行
        int startRow = 0;
        int endRow = n-1;
        //开始列和结束列
        int startCol = 0;
        int endCol = n-1;
        
        int item = 1;
        while(true){
        	//从左向右遍历一行
            for(int i = startCol; i <= endCol; i++){
                answer[startRow][i] = item;
                item++;
            }
            //startRow++判断是否越界
            if(++startRow > endRow) break;
            
            //有上往下
            for(int j = startRow; j <= endRow; j++){
                answer[j][endCol] = item;
                item++;
            }
            if(--endCol < startCol) break;
            
            //从右向左
            for(int k = endCol; k >= startCol; k--){
                answer[endRow][k] = item;
                item++;
            }
            
            //从下向上
            if(--endRow < startRow) break;
            for(int p = endRow; p >= startRow; p--){
                answer[p][startCol] = item;
                item++;
            }
            if(++startCol > endCol) break;
        }
        
        return answer;
    }
}
