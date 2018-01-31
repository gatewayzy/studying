package _programming.leetcode151withexplain;

/**
 * 本题题意：判断一棵树是否是平衡二叉树，平衡二叉树的左右子树的高度相差不会超过1
 * 
 * 解题思路：其实还是获取左右子树的高度  如果差别查过1，那么就返回false
 * 
 * 错误想法：只要获取左子树高度和右子树高度进行判断。因为每个子树可能不是平衡的，高度和平不平没有关系。只能是每个节点都是平衡的才能是平衡二叉树。
 *
 */
public class BalancedBinaryTree041 {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public boolean isBalanced(TreeNode root) {
	    if(root == null){
	    	return true;
	    }
	    
	    //判断本身是不是
	    int leftHeight = getTreeHeight(root.left);
	    int rightHeight = getTreeHeight(root.right);
	    if(Math.abs(leftHeight - rightHeight) > 1){
	    	return false;
	    }
		
	    //判断左子树是不是
	    if(root.left != null){
	    	boolean leftResult = isBalanced(root.left);
	    	if(leftResult == false){
	    		return false;
	    	}
	    }
	    
	    //判断右子树是不是
	    if(root.right != null){
	    	boolean rightResult = isBalanced(root.right);
	    	if(rightResult == false){
	    		return false;
	    	}
	    }

		return true;
	}
	
	//给定节点  求出其高度  【树的高度是最高的数值】
	public int getTreeHeight(TreeNode node){
		if(node == null){
			return 0;
		}
		
		if(node.left == null && node.right == null){
			return 1;
		}
		
		int leftHeight = getTreeHeight(node.left);
		int rightHeight = getTreeHeight(node.right);
		return  leftHeight >= rightHeight? leftHeight+1 : rightHeight+1;
	}
}
