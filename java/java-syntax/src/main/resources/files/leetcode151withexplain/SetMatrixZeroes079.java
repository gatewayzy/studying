package _programming.leetcode151withexplain;

/**
 *  本题题意：给出一个矩阵   把矩阵中为0的所有的元素的行和列都变成0 
 *	
 *	本题思路：通过一个矩阵记录住原来矩阵中的0的位置。然后遍历该矩阵里面的标记为，然后修改原来矩阵的行和列就可以了。
 *
 *	本题注意：之所以用一个新的矩阵记录原来矩阵中0的位置，就是因为怕在原来矩阵上做修改的话，会影响后面的判断
 */
public class SetMatrixZeroes079 {
	
	
	 public void setZeroes(int[][] matrix) {
	        int m = matrix.length;
	        int n = matrix[0].length;
	        
	        //找一个数组  用于记录原有为0的位置
	        int[][] zeroPlace = new int[m][n];
	        
	        int i;
	        int j;
	        //初始化zeroPlace
	        for(i = 0; i < m; i++){
	            for(j = 0; j < n; j++){
	                if(matrix[i][j] == 0){
	                   zeroPlace[i][j] = 1;
	                }
	            }
	        }
	        
	        //设置原有的数组
	        for(i = 0; i < m; i++){
	            for(j = 0; j < n; j++){
	                if(zeroPlace[i][j] == 1){
	                   setZerosDetail(matrix, i, j);
	                }
	            }
	        }
	    }
	    
	 	//把对应元素的行和列设置为0
	    public void setZerosDetail(int[][] matrix, int x, int y){
	        int m = matrix.length;
	        int n = matrix[0].length;
	        for(int i = 0; i < m; i++){
	            matrix[i][y] = 0;
	        }
	        
	        for(int j = 0; j < n; j++){
	            matrix[x][j] = 0;
	        }
	    }
	    
	    
	    
	    
	    //another function
	    
	    public static void setZeroes1(int[][] matrix) {
	        int m = matrix.length;
	        if(m == 0) return;
	        int n = matrix[0].length;
	        
	        for(int i = 0; i < m; i++){
	            for(int j = 0; j < n; j++){
	                if(matrix[i][j] == 0){
	                    matrix[0][j] = 0;
	                }
	            }
	        }
	        
	        for(int i = 1; i < m; i++){
	            if(matrix[i][0] == 0){
	                for(int j = 1; j < n; j++){
	                    matrix[i][j] = 0;
	                }
	            }
	        }
	        
	        for(int j = 1; j < n; j++){
	            if(matrix[0][j] == 0){
	                for(int i = 1; i < m; i++){
	                    matrix[i][j] = 0;
	                }
	            }
	        }
	        
	        for(int i = 0; i < m; i++){
	            if(matrix[i][0] == 0){
	                for(int j = 0; j < m; j++){
	                    matrix[j][0] = 0;
	                }
	                break;
	            }
	        }
	        
	        for(int j = 0; j < n; j++){
	            if(matrix[0][j] == 0){
	                for(int i = 0; i < n; i++){
	                    matrix[0][i] = 0;
	                }
	            }
	            break;
	        }
	        
	    }
	    
	    public static void main(String[] args){
	    	int[][] matrix = {{1,1,1},{0,1,2}};
	    	SetMatrixZeroes079.setZeroes1(matrix);
	    	
	    }
}
