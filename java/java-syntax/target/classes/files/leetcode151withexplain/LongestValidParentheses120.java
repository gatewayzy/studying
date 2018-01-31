package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;

/**
 * 本题题意：给出一个主要由（）组成的字符串，求出里面最长的有效子串是什么。
 * example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * 
 * 解题思路：通过一个arraylist来表示每一个位置是否可以参与拼凑（）,别忘记初始化；通过一个list<integer>来模仿栈，知道哪些元素可以拼凑出（）。然后遍历最长的1的个数
 *
 */
public class LongestValidParentheses120 {
	public int longestValidParentheses(String s) {
		 //模仿数组，标示每一个位置是否可以拼凑出（）
	     List<Integer> items = new ArrayList<Integer>();//recorded as 0 or 1
	     int sLength = s.length();
	     //initailize
	     for(int i = 0; i < sLength; i++){
	         items.add(0);
	     }
	     
	     //栈用于存储下标位置 
	     List<Integer> parentheses = new ArrayList<Integer>(); // regared as a stack
	     
	     //一次遍历每一个元素
	     for(int j = 0; j < sLength; j++){
	         String currentParentheses = s.substring(j,j+1);
	         //如果是（ 压入栈中
	         if(currentParentheses.equals("(")){
	             parentheses.add(j);
	         }else if(currentParentheses.equals(")")){
	             int parenthesesSize = parentheses.size();
	             //判断栈是否为空
	             if(parentheses.size() > 0){
	            	 //获取栈顶元素
	                 int element = parentheses.get(parenthesesSize - 1);
	                 //如果栈顶元素为《
	                 if(s.substring(element,element+1).equals("(")){
	                	 //那么可配对  设置标志位为1
	                     items.set(element, 1);
	                     items.set(j, 1);
	                     parentheses.remove(parenthesesSize - 1);
	                 }
	             //为空  那么就压入到栈中
	             }else{
	            	 parentheses.add(j);
	             }
	         }
	         
	     }
	     
	     //从前往后遍历arraylist 连续是1，那么就++
	     int maxNum = 0;
	     int tempMax = 0;
	     for(int k = 0; k < sLength; k++){
	    	 if(items.get(k) == 0){
	    		 if(maxNum < tempMax){
	    			 maxNum = tempMax;
	    		 }
	    		 tempMax = 0;
	    	 }else{
	    		 tempMax++;
	    	 }
	     }
	     if(maxNum < tempMax){
	    	 maxNum = tempMax;
	     }
	     
	     return maxNum;
       
	}
}
