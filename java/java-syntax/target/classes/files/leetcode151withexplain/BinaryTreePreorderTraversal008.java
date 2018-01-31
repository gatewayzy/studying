package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 先根次序遍历就是先遍历根，然后再遍历左孩子右孩子  
 *
 */
public class BinaryTreePreorderTraversal008 {
	//树的节点数据结构
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
		
		
	/*
	 * 非递归的先根次序遍历。通过一个栈来模仿读取顺序，就是一直先往左孩子走，直到做孩子为空，然后调用节点的右孩子。 
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(p != null || !stack.isEmpty()){
            while(p != null){
                result.add(p.val);
                stack.push(p);
                p = p.left;
            }
            
            if(!stack.isEmpty()){
                p = stack.peek();
                p = p.right;
                stack.pop();
            }
            
        }
        
        return result;
    }
}
