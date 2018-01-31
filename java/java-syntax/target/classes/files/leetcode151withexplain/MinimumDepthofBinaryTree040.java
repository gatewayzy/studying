package _programming.leetcode151withexplain;

/**
 *  本题题意：找出二叉树的最小高度
 *  
 *  本题思路：树的这种递归结构决定的。如果是叶子节点，那么高度为1.然后递归求出左子树高度和右子树高度。
 *
 */
public class MinimumDepthofBinaryTree040 {
	//树节点  数据结构
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        //叶子节点处返回1
        if(root != null && (root.left == null && root.right == null)){
            return 1;
        }
        
        //获取左子树高度
        //获取右子树高度
        int leftHeight = 0;
        int rightHeight = 0;
        if(root.left != null){
            leftHeight = minDepth(root.left);
        }
        
        if(root.right != null){
            rightHeight = minDepth(root.right);
        }
        
        
        //获取结果  判断左右子树情况
        int result = 0;
        if(root.left != null && root.right != null){
        	result = leftHeight < rightHeight? leftHeight:rightHeight;
        }else if(root.left != null && root.right == null){
        	result = leftHeight;
        }else{
        	result = rightHeight;
        }
        
        return 1 + result;
        
    }
}
