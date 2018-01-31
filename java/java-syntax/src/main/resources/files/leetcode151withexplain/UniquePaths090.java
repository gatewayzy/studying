package _programming.leetcode151withexplain;

/**
 *	 本题题意：给出一个二维矩阵，然后从左上角的start位置开始到右下角的finish位置结束  为一共有多少路径
 *
 *	本题思路：通过dp的方式获取结果
 *
 *	对于一些求次数，求能否的问题，很多就是通过dp的方式获取。
 *  
 */
public class UniquePaths090 {
	//f[i][j] = f[i-1][j] + f[i][j-1]
    public int uniquePaths(int m, int n) {
        
    	 //声明一个二维矩阵
         int[][] f = new int[m][n];
        
         //初始化第一行和第一列  因为只能往右走和往下走   所以都初始化为1
         for(int i = 0; i < n; i++)
            f[0][i] = 1;
             
         for(int i = 0; i < m; i++)
             f[i][0] = 1;
             
         //其他地方的数值就等于上面的结果加上左边的结果
         for(int i = 1; i < m; i++)
             for(int j = 1; j < n; j++)
                 f[i][j] = f[i-1][j] + f[i][j-1];
                 
        return f[m-1][n-1];
    }
}
