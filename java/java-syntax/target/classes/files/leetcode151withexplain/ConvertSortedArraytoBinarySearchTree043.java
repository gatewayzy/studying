package _programming.leetcode151withexplain;

/**
 *  本题题意：将有序数组转变为二叉搜索树
 *  
 *  本题思路：和将链表转化为二叉搜索树差不多   都是中间位置作为根节点，左边作为左子树，右边作为右子树。递归调用就可以了。
 *
 */
public class ConvertSortedArraytoBinarySearchTree043 {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public TreeNode sortedArrayToBST(int[] num) {
        TreeNode answer = getBST(num,0,num.length-1);
        return answer;
	 }
	    
	 public TreeNode getBST(int[] num, int startPosition,int endPosition){
        if(num.length == 0){
            return null;
        }
        
        //边界条件 
        if(startPosition == endPosition){
            return new TreeNode(num[startPosition]);
        }
        
        //获取中间节点作为根节点
        int middlePosition = (endPosition + startPosition)/2;
        TreeNode root = new TreeNode(num[middlePosition]);
        
        //左子树
        if(startPosition <= middlePosition -1){
        	root.left = getBST(num, startPosition,middlePosition-1);
        }
        
        //右子树
        if(middlePosition < endPosition){
        	root.right = getBST(num, middlePosition+1,endPosition);
        }

        return root;
   }
}
