package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 *  本题题意：给出一棵二叉树  按层次返回二叉树结果
 *  
 *   Given binary tree {3,9,20,#,#,15,7},
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its level order traversal as:
	[
	  [3],
	  [9,20],
	  [15,7]
	]
	
	本题解题思路：通过宽度优先遍历的方式，一层一层的获取树中的节点，用一个变量存在这一层次的节点的数目。
	
	以后也会用到：模拟队列，宽度优先遍历二叉树；记录住每一个层次节点的数目，方便取节点数据的时候知道取到什么位置
 *
 */
public class BinaryTreeLevelOrderTraversal049 {
	
	//树节点 数据结构
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<ArrayList<Integer>>();
        }
        
        //用于存储结果
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        //用于记录每一层的结果
        ArrayList<Integer> levelNumbers = new ArrayList<Integer>();
        //用于模仿队列
        ArrayList<TreeNode> likeQueue = new ArrayList<TreeNode>();
        likeQueue.add(root);
        
        int circleNum = 1;
        while(likeQueue.size() > 0){
            levelNumbers = new ArrayList<Integer>();
            //从likequue中获取数据   放入到当前层次结果中 
            int i = 0;
            while(i < circleNum){
                levelNumbers.add(likeQueue.get(i).val);
                i++;
            }
            //增加到结果中
            results.add(levelNumbers);
            
            
            i = 0;
            //用于记录下一层次有多少节点
            int newcircleNum = 0;
            while(i < circleNum){
            	//获取队列的头结点，然后将其左右孩子都压入到队列中
                TreeNode currentnode = likeQueue.get(0);
                likeQueue.remove(0);
                if(currentnode.left != null){
                    likeQueue.add(currentnode.left);
                    newcircleNum++;
                }
                
                if(currentnode.right != null){
                    likeQueue.add(currentnode.right);
                    newcircleNum++;
                }
                i++;
            }
            
            //将最新的数值复制给circle，方便下一轮循环使用
            circleNum = newcircleNum;
        }
        
        return results;
    }
}
