package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 *  本题题意：有一棵二叉搜索树中的某两个节点交换了顺序，尽快恢复二叉树  不要改变原有的数据结构
 *  Two elements of a binary search tree (BST) are swapped by mistake.ecover the tree without changing its structure.
 *
 *	一般思路：通过宽度优先遍历的方式获取二叉搜索树的节点。因为二叉搜索树按中序遍历就是一个递增顺序。然后找到这两个节点，然后交换数据。
 *
 *	本题的要求是尽量使用比较少的空间。使用常量空间。
 *  
 */
public class RecoverBinarySearchTree052_Done {
	//树节点  数据结构
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public void recoverTree(TreeNode root) {
        if(root == null) return;
        ArrayList<TreeNode> inorderSequence = inorder(root);
        int inorderSize = inorderSequence.size();
        TreeNode firstWrongNode = null;
        TreeNode secondWrongNode = null;
        int i;
        for(i = 0; i < inorderSize-1; i++){
            if(inorderSequence.get(i).val > inorderSequence.get(i+1).val){
                firstWrongNode = inorderSequence.get(i);
                break;
            }
        }
        
        int j;
        for(j = inorderSize-1; j >= 1; j--){
            if(inorderSequence.get(j).val < inorderSequence.get(j-1).val){
                secondWrongNode = inorderSequence.get(j);
                break;
            }
        }
        
        int temp = firstWrongNode.val;
        firstWrongNode.val = secondWrongNode.val;
        secondWrongNode.val = temp;
        
    }
    
    public ArrayList<TreeNode> inorder(TreeNode root){
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(root == null){
            return result;
        }
        
        if(root.left != null){
            result.addAll(inorder(root.left));
        }
        
        result.add(root);
        
        if(root.right != null){
            result.addAll(inorder(root.right));
        }
        
        return result;
    }
    
    
    //以下是常量空间的方法
    TreeNode pre = null;
    TreeNode mistake1 = null;
    TreeNode mistake2 = null;
    
    public void recoverTree1(TreeNode root) {
        recursiveTree(root);
        if(mistake1 != null && mistake2 != null){
            int temp = mistake1.val;
            mistake1.val = mistake2.val;
            mistake2.val = temp;
        }
    }
    
    //通过递归调用的方式获取  pre指针用于记录前面的内容
    public void recursiveTree(TreeNode root){
        if(root == null) return;
        
        if(root.left != null){
            recursiveTree(root.left);
        }
        
        if(pre != null && root.val < pre.val){
            if(mistake1 == null){
                mistake1 = pre;
                mistake2 = root;
            }else{
                mistake2 = root;
            }
        }
        
        pre = root;
        if(root.right != null){
            recursiveTree(root.right);
        }
        
    } 
    
}
