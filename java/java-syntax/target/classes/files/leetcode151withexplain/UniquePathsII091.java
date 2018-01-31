package _programming.leetcode151withexplain;

/**
 *	本题题意：给出一个二维矩阵，矩阵中的1表示障碍  0表示空格可行  问从左上角到右下角一共有多少种路径 
 *	
 *	本题思路：通过dp的方式计算数值。
 *	
 *	注意点：初始化的时候，别忘了剩余位置也要赋值为-1
 */
public class UniquePathsII091 {
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //二维矩阵
        int[][] f = new int[m][n];
        
        //初始化第一列   如果有障碍的是1 那么后序的肯定都是0了
        int i;
        for(i = 0; i < m; i++){
        	//遇到一个障碍  那么后面的都是0 直接break就行了
            if(obstacleGrid[i][0] == 1){
                break;
            }else{
                f[i][0] = 1;
            }
        }
        
        //其他位置初始化为-1
        for(;i < m; i++){
            f[i][0] = -1;
        }
        
        //初始化行
        for(i = 0; i < n; i++){
            if(obstacleGrid[0][i] == 1){
                break;
            }else{
                f[0][i] = 1;
            }
        }
        
        for(;i < n; i++){
            f[0][i] = -1;
        }
        
        //递推公式计算数值
        for(i = 1; i < m; i++){
        	for(int j = 1; j < n; j++){
        		//如果是障碍  直接跳过
        		if(obstacleGrid[i][j] == 1){
        			continue;
        		}
        		
        		//左边和上边都是-1  赋值为-1
        		if(f[i-1][j] == -1 && f[i][j-1] == -1){
        			f[i][j] = -1;
        		}
        		
        		//如果一边是-1  一边不是
        		if(f[i-1][j] == -1 && f[i][j-1] != -1){
        			f[i][j] = f[i][j-1];
        		}
        		
        		if(f[i-1][j] != -1 && f[i][j-1] == -1){
        			f[i][j] = f[i-1][j];
        		}
        		
        		//如果两边都不是-1
        		if(f[i-1][j] != -1 && f[i][j-1] != -1){
        			f[i][j] = f[i-1][j] + f[i][j-1];
        		}
        		
        	}
        }
        
        if(f[m-1][n-1] == -1){
            return 0;
        }else{
            return f[m-1][n-1];
        }
    }
}
