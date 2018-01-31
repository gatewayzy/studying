package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 *  本题题意：给出n，返回所有的标示0-n的所有的二叉搜索树
 *  
 *  解题思路：
 *  也是遍历每一个位置，让每一个位置作为根节点，然后求出其左子树的所有可能和右子树的所有可能，然后进行组合。获得最终的结果。
 *  
 *  注意点：递归调用的边界条件要慎重
 *
 */
public class UniqueBinarySearchTreesII055 {
	//树节点  数据结构
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; left = null; right = null; }
	}
	
	public ArrayList<TreeNode> generateTrees(int n) {
        return generateNodes(1,n,n);
    }
    
	//递归构建   三个参数  开始和结束位置   n：最大值
    public ArrayList<TreeNode> generateNodes(int start, int end,int n){
        ArrayList<TreeNode> currentResults = new ArrayList<TreeNode>();
        
        //边界条件xinglong
        if(start > end){
            currentResults.add(null);
            return currentResults;
        }
        
        //边界条件
        if(start == end){
            currentResults.add(new TreeNode(start));
            return currentResults;
        }
        
        //从前往后遍历  一次作为根节点 
        for(int i = start; i <= end; i++){
        	//获取左子树的所有可能
            ArrayList<TreeNode> leftResults =  generateNodes(start,i-1,n);
            //获取右子树的所有可能
            ArrayList<TreeNode> rightResults =  generateNodes(i+1,end,n);
            //构建各种组合  增加到结果中
            for(int j = 0; j < leftResults.size(); j++){
                for(int k = 0; k < rightResults.size(); k++){
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = leftResults.get(j);
                    newNode.right = rightResults.get(k);
                    currentResults.add(newNode);
                }
            }
        }

        return currentResults;
        
    }
	
}
