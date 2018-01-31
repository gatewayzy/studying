package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 * 本题是希望给出所有的树根节点到叶子节点之和等于给定值的所有路径
 * 
 * 本题思路：通过优先遍历的方式获取各个路径，然后当满足边界条件的时候，加入到总的结果中。
 * 
 * 注意点：递归调用的时候，传递的是一个复制，而不是原本的传入，因为应用会有所改变。
 *
 */
public class PathSumII039 {

	//树节点 数据结构
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public  ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		//此题的解题思路是传统的一种套路   可以获取所有的路径
		ArrayList<ArrayList<Integer>> answers = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> likeStack = new ArrayList<Integer>();
		answers = getResults(answers, likeStack, root, sum);
		return answers;
    }
	
	public ArrayList<ArrayList<Integer>> getResults(ArrayList<ArrayList<Integer>> answers,ArrayList<Integer> likeStack,TreeNode root,int sum){
		
		if(root == null){
			return answers;
		}
		
		
		likeStack.add(root.val);
		//current node satisfies the condition
		if(root.left == null && root.right == null && root.val == sum){
			answers.add(likeStack);
		}
		
		
		//jude left
		if(root.left != null){
			//完全复制了一份  然后传递到下一轮调用
			ArrayList<Integer> newLikeStack = new ArrayList<Integer>();
			for(int i = 0; i < likeStack.size(); i++){
				newLikeStack.add(likeStack.get(i));
			}
			getResults(answers,newLikeStack,root.left,sum-root.val);
		}
		
		if(root.right != null){
			ArrayList<Integer> newLikeStack = new ArrayList<Integer>();
			for(int i = 0; i < likeStack.size(); i++){
				newLikeStack.add(likeStack.get(i));
			}
			getResults(answers,newLikeStack,root.right,sum-root.val);
		}
		
		
		return answers;
	}
	
}
