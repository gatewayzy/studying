package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 * 本题题意：将一个二叉树变成一个链表 ，right变成next使用
 *
 * 本题解题思路：先通过先序遍历获得所有的节点，然后依次设置right指针，变成一个链表。
 * 注意的地方就是深度优先遍历如何做。另外，每个节点的左节点设置为null。右节点设置为下一个节点。
 * 
 * 
 */
public class FlattenBinaryTreetoLinkedList037_Done {
	//树节点  数据结构 
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        
        ArrayList<TreeNode> results = new ArrayList<TreeNode>();
        getRootFirstList(results,root);
        
        //获取优先遍历的结果  然后依次设置每一个节点的right指针为下一个
        int resultSize = results.size();
        for(int i = 0; i < (resultSize - 1); i++){
            results.get(i).left = null;
            results.get(i).right = results.get(i+1);
        }
        
        //别忘了最后叶子节点的设置
        results.get(resultSize-1).left = null;
        results.get(resultSize-1).right = null;
    }
    
    //先序遍历
    public static void getRootFirstList(ArrayList<TreeNode> results, TreeNode root){

    	//边界条件  即 如果是一个叶子节点  然后加入到results中
        if(root != null && (root.left == null && root.right == null)){
            results.add(root);
            return;
        }
        
        //先将root加入results
        results.add(root);
        //遍历左孩子
        if(root.left != null){
           getRootFirstList(results, root.left); 
        }
        
        //遍历右孩子
        if(root.right != null){
            getRootFirstList(results, root.right);
        }
        
    }
    
    
    public void flatten2(TreeNode root) {
        toList(root);
    }
    
    //通过递归调用的方式  符合树的结构特点
    public void toList(TreeNode root){
        if(null == root) return;
        
        //判断左孩子是否为空
        if(root.left != null){
            toList(root.left);
            
            //找到左边连接的时候的最后一个节点
            TreeNode cur = root.left;
            while(cur.right != null){
                cur = cur.right;
            }
            
            //修改连接
            cur.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        if(root.right != null){
            toList(root.right);
        }
    }
}
