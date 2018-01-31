package _programming.leetcode151withexplain;

/**
 *  本题题意：给出一个二维矩阵，每一个数都是非负的。从左上角到右下角最短的路径和是多少？ 只能向右自动和向下移动。 
 *	
 *	解题思路：因为只要获取最小和就可以  所以可以通过dp的方式获取
 */
public class MinimumPathSum089 {
	
	public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        
        //初始化第一列
        int tempSum = grid[0][0];
        for(int i = 1; i < rows; i++){
            tempSum += grid[i][0];
            grid[i][0] = tempSum;
        }
        
        //初始化第一行
        tempSum = grid[0][0];
        for(int j = 1; j < columns; j++){
            tempSum += grid[0][j];
            grid[0][j] = tempSum;
        }
        
        //dp[i][j] = min(dp[i-1][j]+dp[i][j],dp[i][j-1]+dp[i][j])
        for(int p = 1; p < rows; p++){
            for(int q = 1; q < columns; q++){
                grid[p][q] = getMinNum((grid[p-1][q]+grid[p][q]),(grid[p][q-1]+grid[p][q]));
            }
        }
        
        //返回最有的结果就可以
        return grid[rows-1][columns-1];
    }
    
    public int getMinNum(int a, int b){
        if(a < b){
            return a;
        }else{
            return b;
        }
    }
}
