package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 *  本题题意：给出一个三角形结构的数据，然后找到从顶部元素到底部元素和最小的路径
 *  For example, given the following triangle
	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
	The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). 
	
	一般思路：感觉就像一个变相的二叉树，找到从根节点到叶子节点的最小路径。
	
	本题思路：通过dp的思想
	dp[i] = a[i][j] + max(a[i+1][j],a[i+1][j+1]);
 *
 */
public class Triangle031 {

	 public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
	        if(triangle == null || triangle.size() == 0){
	            return 0;
	        }
	        
	        int rows = triangle.size();
	        //dp方式，a[]表示的就是a[i]此时的最小值
	        int[] a = new int[rows];
	        
	        //初始化，可以初始化数组的数据
	        for(int i = 0; i < rows; i++){
	            a[i] = triangle.get(rows-1).get(i);
	        }
	        
	        //从倒数第二行往倒数第一行遍历
	        for(int i = rows-2; i >= 0; i--){
	            for(int j = 0; j < triangle.get(i).size(); j++){
	                int belowLeft = a[j];
	                int belowRight = a[j+1];
	                //计算数值 a[i] = a[i][j] + min(a[i+1][j],a[i+1][j+1])
	                a[j] = triangle.get(i).get(j) + (belowLeft < belowRight ? belowLeft:belowRight);
	            }
	        }
	        
	        return a[0];
	    }
	 
	 
	    public static int minimumTotal2(ArrayList<ArrayList<Integer>> triangle) {
	        int m = triangle.size();
	        if(m == 0) return 0;
	        int n = triangle.get(m-1).size();
	        
	        int[] answer = new int[n];
	        for(int i = m-1; i >= 0; i--){
	            for(int j = i; j >= 0; j--){
	                if(i == (m-1)){
	                    answer[j] = triangle.get(i).get(j);
	                }else{
	                    answer[j] = Math.min(answer[j],answer[j+1])+triangle.get(i).get(j);   
	                }
	            }
	        }
	        
	        return answer[0];
	    }
	    
	    public static void main(String[] args){
	    	ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
	    	ArrayList<Integer> a = new ArrayList<Integer>();
	    	a.add(-1);
	    	ArrayList<Integer> b = new ArrayList<Integer>();
	    	b.add(2);
	    	b.add(3);
	    	ArrayList<Integer> c = new ArrayList<Integer>();
	    	c.add(1);
	    	c.add(-1);
	    	c.add(-1);
	    	
	    	temp.add(a);
	    	temp.add(b);
	    	temp.add(c);
	    	
	    	Triangle031.minimumTotal2(temp);
	    }
}
