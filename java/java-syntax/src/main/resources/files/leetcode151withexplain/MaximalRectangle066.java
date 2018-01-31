package _programming.leetcode151withexplain;

import java.util.Stack;

/**
 *  本题题意：给出一个二维矩阵  矩阵中都是0或者1  找出矩阵中连续都是1的最大矩形区域 
 *
 *	本题解题思路：
 *  1、首先借助的是：给一个数组，数组元素的值代表矩形的高度，求出这些矩形构成的最大面积。
 *  2、声明一个二维矩阵，能够记录住每一列从上到下的1值度多少。然后一行一行的计算 ，求出最大面积即可.
 */
public class MaximalRectangle066 {
	
	public int maximalRectangle(char[][] matrix) {
		//获取矩阵的长和宽
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        if(n == 0) return 0;
        
        //初始化第一行数据
        int[][] f = new int[m][n];
        for(int i = 0; i < n; i++){
            f[0][i] = matrix[0][i] == '1'? 1 : 0;
        }
        
        //声明二维矩阵f,二维矩阵中的f[m][n]记录的是m行中第0列从上到n行中1的数目
        for(int i = 0; i < n; i++){
            for(int j = 1; j < m; j++){
                f[j][i] = matrix[j][i] == '1'? f[j-1][i] + 1 : 0;
            }
        }
        
        //一行一行的遍历矩阵   每一行都可以获得一个最大的矩形面积   求出最大的面积
        int maxarea = 0;
        int temparea = 0;
        for(int k = 0; k < m; k++){
            temparea = getlargestRectangle(f[k],n);
            if(temparea > maxarea){
                maxarea = temparea;
            }
        }
        
        return maxarea;
    }
    
	
	//给出一个数组  数组元素大小代表条形的高度  求出最大的矩形
    public int getlargestRectangle(int[] height,int length){
         int size = length;
         //坐标栈和高度栈
		 Stack<Integer> indexStack = new Stack<Integer>();
		 Stack<Integer> heightStack = new Stack<Integer>();
		 
		 int maxarea = 0;
		 int temparea = 0;
		 for(int i = 0; i < size; i++){
			 
			 //如果栈为空或者后来的高度大于之前压入的高度  那么就压入栈中
			 if(indexStack.isEmpty() == true || height[i] > heightStack.peek()){
				 indexStack.push(i);
				 heightStack.push(height[i]);
			 //当要压入的高度小于栈顶的高度时
			 }else if(height[i] < heightStack.peek()){
				 //lastindex用于记录下标  计算矩形的时候就是矩形的宽度
				 int lastindex = 0;
				 //不断循环弹出高度
				 while(indexStack.isEmpty() == false && height[i] < heightStack.peek()){
					 lastindex = indexStack.pop();
					 //计算面积
					 temparea = heightStack.pop() * (i - lastindex);
					 if(temparea > maxarea){
						 maxarea = temparea;
					 }
				 }
				 //讲坐标和高度压入矩阵
				 indexStack.push(lastindex);
				 heightStack.push(height[i]);				 
			 }
			 
		 }
		 
		 //等于的情况以及一直压入的情况等
		 while(!indexStack.isEmpty()){
			 temparea = heightStack.pop() * (size - indexStack.pop());
			 if(temparea > maxarea){
				 maxarea = temparea;
			 }
		 }
		 
		 return maxarea;
    }
}
