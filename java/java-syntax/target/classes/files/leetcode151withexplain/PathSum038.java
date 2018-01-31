package _programming.leetcode151withexplain;

/**
 * 本题提议：给出一个二叉树，判断树中是否存在一个路径和等于给定的值
 * 
 * 解题思路：其实就是树的遍历，只是能够记录住当前路径和是多少。
 * 
 * 再次体验：有些题目是要记录路径上的每一个值，有的题目只需要知道最后的节点。
 * 
 * 基本遍历过程还是和各种遍历方式一致（先序遍历方式）
 *
 */
public class PathSum038 {
	
	//树节点  数据结构
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	 public boolean hasPathSum(TreeNode root, int sum) {
	        
	        //deal special situation
	        if(root == null){
	            return false;
	        }
	        
	        //judge if current situation satisfy the conditions
			if(root.left == null && root.right == null && sum == root.val){
				return true;
			}
			
			
			if(root.left != null){
				boolean leftResult = hasPathSum(root.left,(sum-root.val));
				if(leftResult == true){
					return true;
				}
			}
			
			if(root.right != null){
				boolean rightResult = hasPathSum(root.right, (sum-root.val));
				if(rightResult == true){
					return true;
				}
			}
			
			return false;        
	    }
}
