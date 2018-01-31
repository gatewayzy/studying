package _programming.leetcode151withexplain;

/**
 *  本题题意：给出两颗二叉树   判断两颗二叉树是否相等
 *
 *  解题思路：也是根据二叉树的递归结构判断两棵树是否相同
 *  
 *  边界条件比较多。这个要特别注意。
 */
public class SameTree051 {
	//树节点  数据结构
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	 public boolean isSameTree(TreeNode p, TreeNode q) {
		 
		 
        boolean result = true;
        
        if(p == null && q == null){
            return true;
        }
        
        if(p == null && q != null){
            result = false;
            return result;
        }
        
        if(p != null && q == null){
            result = false;
            return result;
        }
        
        if(p.val != q.val){
            result = false;
            return result;
        }
        
        if((p.left != null && q.left == null) || (p.left == null && q.left != null )){
            result = false;
            return result;
        }
        
        if((p.right != null && q.right == null) ||(p.right == null && q.right != null)){
            result = false;
            return result;
        }
        
        if(p.left != null && q.left != null){
            result = isSameTree(p.left, q.left);
            if(result == false){
                return result;
            }
        }
        
        if(p.right != null && q.right != null){
            result = isSameTree(p.right, q.right);
            if(result == false){
                return result;
            }
        }
        
        return result;
	        
	}
}
