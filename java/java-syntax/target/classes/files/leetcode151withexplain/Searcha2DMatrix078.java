package _programming.leetcode151withexplain;

/**
 *  本题题意：给出一个二维矩阵，每一行的数字都是递增，每一行的第一个数都大于上一行的最后一个数
 *	
 *	本题思路：通过两次二分查找的方式。 首先找到在哪一行  而后找到在哪一列
 *
 *	其他思路：能够将矩阵中的i，j转化为线性上的某一个值，然后通过二分方法获取整个数值就可以了。
 */
public class Searcha2DMatrix078 {

	public boolean searchMatrix(int[][] matrix, int target) {
        int rowNum = getColumnPosition(matrix, target);
        if(rowNum == -1) return false;
        
        int columnNum = getRowPosition(matrix,rowNum,target);
        if(columnNum == -1) return false;
        else return true;
    }
    
	public int getRowPosition(int[][] matrix,int rowindex, int target){
        int columns = matrix[rowindex].length;
        
        int left = 0;
        int right = columns-1;
        int middle = -1;
        //二分查找的方式找到元素
        while(left <= right){
            middle = (left + right) >> 1;
            if(matrix[rowindex][middle] == target){
                return middle;
            }
            
            if(matrix[rowindex][middle] > target){
                right = middle-1;
            }else{
                left = middle+1;
            }
            
        } 
        

        return -1;
    }
    
	//获取在哪一行
    public int getColumnPosition(int[][] matrix, int target){
        int rows = matrix.length;
        //如果就有一行  那么返回这一行的行号就可以
    	if(rows == 1){
    		return 0;
    	}
    	
    	//判断最后一行是否满足条件，如果额可以，则返回
        if(matrix[rows-1][0] <= target){
            return rows-1;
        }
        
        //一次从开始往后遍历，返回满足条件的行号
        for(int i = 0; i < rows-1; i++){
            if(matrix[i][0] <= target && matrix[i+1][0] > target){
                return i;
            }
        }
        
        return -1;
    }
}
