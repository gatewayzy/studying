package _programming.leetcode151withexplain;

/**
 * 本题题意：给出一个二维n*n矩阵，代表一个图像，返回其向右反转90度之后的图像矩阵
 * 
 *	解题思路：通过一个临时矩阵存住原来的矩阵，然后在赋值一遍就可以了
 */
public class RotateImage105_Done {
	
	public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] tempmatrix = new int[n][n];
        
        //用一个temp矩阵存储原来矩阵中的所有值
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                tempmatrix[i][j] = matrix[i][j];
            }
        }
        
        //遍历一遍重新赋值就行了
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[j][n-1-i] = tempmatrix[i][j];
            }
        }
        
    }
	
	//通过先对角线交换，然后在上下交换就可以了。
	public void rotate1(int[][] matrix) {
        int n = matrix.length;
        if(n <= 1) return;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = temp;
            }
        }
        
        for(int i = 0; i < n/2; i++){
            for(int j = 0; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        }
        
        
    }
}
