package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后续遍历，左孩子，右孩子，根节点
 * 
 * 采用递归的思想，递归中采用的思路就是假设调用函数都是成功的，那么把各个问题获得之后，然后再处理数据就行，不用考虑的太细节。
 *
 *http://www.cnblogs.com/dolphin0520/archive/2011/08/25/2153720.html
 */
public class BinaryTreePostorderTraversal007 {
	
	//树的节点数据结构
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	
	//采用递归调用的方式  
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
        
		//每一轮都用新的数组列表
        ArrayList<Integer> results =  new ArrayList<>();
		
		if(root == null){
			return results;
		}
		
		//获取左子树和右子树的遍历结果  加入到这一轮的结果中
		ArrayList<Integer> leftSonArray = postorderTraversal(root.left);
		ArrayList<Integer> rightSonArray = postorderTraversal(root.right);
		if(leftSonArray != null){
		    results.addAll(leftSonArray);
		}
		if(rightSonArray != null){
		    results.addAll(rightSonArray);
		}
		
		results.add(root.val);
		
	    
	    return results;
    }
	
	
	/**
	 * 以下是非递归的方式进行后根次序遍历
	 * 
	 * 通过一个栈来控制节点的打印顺序
	 * 
	 * 打印一个节点的条件是：节点的左右孩子都是空的，此时就是叶子节点，打印出来；而后就是自己的子节点中有被访问的，也就是pre属于自己的一个孩子节点。pre用来记录前一个遍历的节点是什么。
	 * 
	 * 压入栈的顺序就是先压入自己的右孩子，然后是自己的左孩子
	 * 
	 */
	public List<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        TreeNode cur = null;
        stack.push(root);
        while(!stack.isEmpty()){
            cur = stack.peek();
            if((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))){
                result.add(cur.val);
                stack.pop();
                pre = cur;
                continue;
            }
            
            if(cur.right != null){
                stack.push(cur.right);
            }
            
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
        
        return result;
    }
}
