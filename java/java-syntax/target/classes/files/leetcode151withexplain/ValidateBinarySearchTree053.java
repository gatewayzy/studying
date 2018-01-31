package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 *  本题题意：判断一棵树是不是二叉搜索树。 
 *	一般思路：通过中序遍历读取树，然后判断其是否是递增顺序
 */
public class ValidateBinarySearchTree053 {
	//树节点  数据结构
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        ArrayList<Integer> result = inorder(root);
        int resultSize = result.size();
        for(int i = 0; i < resultSize-1; i++){
            if(result.get(i) >= result.get(i+1)){
                return false;
            }
        }
        
        return true;
    }
    
    public ArrayList<Integer> inorder(TreeNode root){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root.left != null){
            result.addAll(inorder(root.left));
        }
        
        result.add(root.val);
        
        if(root.right != null){
            result.addAll(inorder(root.right));
        }
        
        return result;
    }
    
    
    /**
     *  这个题目本身其实使用中根次序遍历是非常容易做判断的。至少应该先想到的是这个方法，二叉搜索树的特点就是每个节点左子树的节点值都小于当前节点之，右子树所有节点都大于当前节点值。那么不能用全局变量记录最大最小值，所以应该能记录住每个节点当前的情况，
     *  于是乎出现了这种方法，三个参数，传递当前比较的最大值最小值。
     */
    public boolean isValidBST2(TreeNode root) {
        if(root == null) return true;
        return helper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    public boolean helper(TreeNode root, int min, int max){
        if(root.val <= min || root.val >= max) return false;
        
        if(root.left != null){
            if(root.left.val >= root.val) return false;
            if(!helper(root.left,min,root.val)) return false;
        }
        
        if(root.right != null){
            if(root.right.val <= root.val) return false;
            if(!helper(root.right,root.val,max)) return false;
        }
        
        return true;
    }
}
