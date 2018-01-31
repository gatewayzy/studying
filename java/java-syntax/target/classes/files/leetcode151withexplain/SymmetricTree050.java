package _programming.leetcode151withexplain;

/**
 * 判断一棵树是不是对称二叉树
 * 
 * For example, this binary tree is symmetric:

	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3
	But the following is not:
	    1
	   / \
	  2   2
	   \   \
	   3    3
	
	一般思路：通过宽度优先遍历   获取每一层的节点   然后判断这一层节点是否是对称的就可以了  但是时间会超时
	
	本题思路：
	
 *
 */
public class SymmetricTree050 {
	//树节点  数据结构
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public boolean isSymmetric(TreeNode root) {
        //以下为特殊情况处理
		if(root == null){
            return true;
        }
        
        if(root.left == null && root.right == null){
            return true;
        }
        
        return isMirror(root.left,root.right);
    }
    
	//递归调用   通过二叉树特有的性质进行递归调用
    public boolean isMirror(TreeNode leftson,TreeNode rightson){
    	//边界条件非常重要
        if(leftson == null && rightson == null)  return true;
        if(leftson == null && rightson != null)  return false;
        if(leftson != null && rightson == null)  return false;
        if(leftson.val != rightson.val) return false;
        return isMirror(leftson.left,rightson.right)&&isMirror(leftson.right,rightson.left);
    }
}
