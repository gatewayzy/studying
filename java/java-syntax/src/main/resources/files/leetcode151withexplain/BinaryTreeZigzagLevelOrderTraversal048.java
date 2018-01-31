package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 * 本题题意：给出一棵二叉树   以z的路径读取二叉树数据  一行一行的读取
 * Given binary tree {3,9,20,#,#,15,7},
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its zigzag level order traversal as:
	[
	  [3],
	  [20,9],
	  [15,7]
	]
 *
 *  其实就和之前44  49差不多  这次只是改变了一下每一行的读取顺序
 */
public class BinaryTreeZigzagLevelOrderTraversal048 {
	
	//树节点
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
	        if(root == null){
	            return new ArrayList<ArrayList<Integer>>();
	        }
	        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
	        ArrayList<Integer> levelNumbers = new ArrayList<Integer>();
	        ArrayList<TreeNode> likeQueue = new ArrayList<TreeNode>();
	        likeQueue.add(root);
	        int circleNum = 1;
	        int level = 0;
	        while(likeQueue.size() > 0){
	            levelNumbers = new ArrayList<Integer>();
	            int i = 0;
	            while(i < circleNum){
	                levelNumbers.add(likeQueue.get(i).val);
	                i++;
	            }
	            
	            //只是做了一个特殊处理   层次的奇数偶数决定了该层次的读取顺序
	            if((level % 2) == 0){
	                results.add(levelNumbers);
	            }else{
	                reverseNumbers(levelNumbers);
	                results.add(levelNumbers);
	            }
	            level++;
	            
	            i = 0;
	            int newcircleNum = 0;
	            while(i < circleNum){
	                TreeNode currentnode = likeQueue.get(0);
	                likeQueue.remove(0);
	                if(currentnode.left != null){
	                    likeQueue.add(currentnode.left);
	                    newcircleNum++;
	                }
	                
	                if(currentnode.right != null){
	                    likeQueue.add(currentnode.right);
	                    newcircleNum++;
	                }
	                i++;
	            }
	            
	            circleNum = newcircleNum;
	        }
	        
	        return results;
	    }
	    
	    public void reverseNumbers(ArrayList<Integer> levelNumbers){
	        int levelSize = levelNumbers.size();
	        for(int i = 0, j = levelSize-1; i < j;i++,j--){
	            int temp = levelNumbers.get(i);
	            levelNumbers.set(i,levelNumbers.get(j));
	            levelNumbers.set(j,temp);
	        }
	        
	    }
}
