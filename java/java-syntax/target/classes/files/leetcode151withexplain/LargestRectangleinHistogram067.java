package _programming.leetcode151withexplain;

import java.util.Stack;

/**
 *  本题题意:给出一个数组求出最大的矩形  
 *  
 *  这个方法也应用在了66题中,可以参考那个解释.
 *  
 *  栈可以记录住之前的操作,两个栈:一个 用于存储下标,计算宽度的时候使用;一个用于存储数组元素,计算高度的时候使用.
 *  
 *  如果高度比当前的栈顶的元素大,那么就压入栈中;如果小于栈顶元素,那么就弹出元素计算矩形面积.
 *
 */
public class LargestRectangleinHistogram067 {
	public int largestRectangleArea(int[] height){
		 int maxarea = 0;
		 int size = height.length;
		 if(size == 0) return 0;
		 if(size == 1) return height[0];
		 
		 Stack<Integer> indexStack = new Stack<Integer>();
		 Stack<Integer> heightStack = new Stack<Integer>();
		 
		 int temparea = 0;
		 for(int i = 0; i < size; i++){
			 if(indexStack.isEmpty() == true || height[i] > heightStack.peek()){
				 indexStack.push(i);
				 heightStack.push(height[i]);
			 }else if(height[i] < heightStack.peek()){
				 int lastindex = 0;
				 while(indexStack.isEmpty() == false && height[i] < heightStack.peek()){
					 lastindex = indexStack.pop();
					 temparea = heightStack.pop() * (i - lastindex);
					 if(temparea > maxarea){
						 maxarea = temparea;
					 }
				 }
				 
				 indexStack.push(lastindex);
				 heightStack.push(height[i]);				 
			 }
			 
		 }
		 
		 while(!indexStack.isEmpty()){
			 temparea = heightStack.pop() * (size - indexStack.pop());
			 if(temparea > maxarea){
				 maxarea = temparea;
			 }
		 }

		 return maxarea;
	}
	
	public static void main(String[] args){
		LargestRectangleinHistogram067 object = new LargestRectangleinHistogram067();
		int[] a = {2,1,5,6,2,3};
		object.largestRectangleArea(a);
	}
}
