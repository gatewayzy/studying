package _programming.leetcode151withexplain;

/**
 * 本题题意：给出一棵二叉树  求出其最大的高度  题目40题是给出树的最小高度
 * 
 * 就是通过递归的方式获取树的高度，然后把左子树高度和右子树高度进行对比   选择比较大的那个就可以了
 *
 */
public class MaximumDepthofBinaryTree047 {
	
	//树节点  数据结构
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public int maxDepth(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        
        if(root != null &&(root.left == null && root.right == null)){
            return 1;
        }
        
        int result = 0;
        int leftHeight = 0;
        int rightHeight = 0;
        if(root.left != null){
            leftHeight = maxDepth(root.left);
        }
        
        if(root.right != null){
            rightHeight = maxDepth(root.right);
        }
        
        result = leftHeight > rightHeight? leftHeight:rightHeight;
        return 1+result;
    }
	
}
