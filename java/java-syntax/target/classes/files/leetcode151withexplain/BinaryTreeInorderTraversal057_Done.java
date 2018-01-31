package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 本题题意：采用非递归的方式对二叉树进行中序遍历
 * 
 * 非递归的前序遍历，中序遍历和后续遍历
 * 
 * 中序遍历和前序遍历差不多，都是优先压入左孩子，只是先序遍历是变压入的时候边打印数值；而中序遍历是弹出的时候打印出数值。
 * post遍历就是通过一个栈，先压入右孩子，再压入左孩子
 *
 */
public class BinaryTreeInorderTraversal057_Done {
	
	//树节点  数据结构
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	//通过递归的方式实现中序遍历
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        
        if(root.left != null){
            result.addAll(inorderTraversal(root.left));
        }
        
        result.add(root.val);
        
        if(root.right != null){
            result.addAll(inorderTraversal(root.right));
        }
        
        return result;
    }
	
	
	//通过非递归的方式
	public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> answer = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode currentNode = root;
        while(currentNode != null || !stack.isEmpty()){
        	//不断的压入左孩子节点
            while(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            
            //将头节点加入到结果中
            if(!stack.isEmpty()){
                currentNode = stack.peek();
                answer.add(currentNode.val);
                stack.pop();
                if(currentNode != null){
                    currentNode = currentNode.right;
                }
            }
            
            
        }
        
        return answer;
    }
	
	
}
