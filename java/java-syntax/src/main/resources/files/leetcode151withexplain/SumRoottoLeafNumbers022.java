package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 * 本题题意：给定一个二叉树，从根节点到所有的叶子节点的字符连起来就是一个字符串表示的数字，把所有的这些数字都加起来。
 * For example,

	    1
	   / \
	  2   3
	The root-to-leaf path 1->2 represents the number 12.
	The root-to-leaf path 1->3 represents the number 13.

	Return the sum = 12 + 13 = 25. 
	
	解题思路：通过深度优先遍历，获取每一个路径，然后存储到结果中。
	
	这种题目要记录住路径，这个时候就需要一个结果集results和临时单个结果temp来做这件事情；
	而像先序遍历等则不需要记住前面的路径，而是逐次遍历规定顺序的点
 *
 */
public class SumRoottoLeafNumbers022 {
	 
	//树节点的数据结构
	 public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	 
	 public int sumNumbers(TreeNode root) {
		 //用于记录所有的的根到叶子节点的路径
	     ArrayList<String> results = new ArrayList<String>();
	     String temp = "";
	     dfsGetRests(results,temp,root);
	     //计算sum结果
	     return calculateResult(results);
	 }
	    
	    
	    public void dfsGetRests(ArrayList<String> results, String temp,TreeNode root){
	        
	    	//边界条件
	    	if(root == null){
	            return;
	        }
	        
	    	//将本节点加入到temp中
	        temp += root.val;

	        //到了叶子节点，则把结果加入到最终结果里面
	        if(root != null && root.left == null && root.right == null){
	            results.add(temp);
	        }
	        
	        //开始遍历，左子树
	        if(root.left != null){
	            dfsGetRests(results, temp,root.left);
	        }
	        
	        //开始遍历，右子树
	        if(root.right != null){
	            dfsGetRests(results, temp,root.right);
	        }
	    }
	    
	    public int calculateResult(ArrayList<String> results){
	        int resultSize = results.size();
	        int result = 0;
	        for(int i = 0; i < resultSize; i++){
	            if(!results.get(i).equals("")){
	                int tempResult = 0;
	                int currentSize = results.get(i).length();
	                for(int j = 0; j < currentSize; j++){
	                    tempResult  = tempResult * 10 + Integer.parseInt(results.get(i).substring(j,j+1));
	                }
	                result += tempResult;
	                
	            }
	                
	        }
	        return result;
	    }
}
