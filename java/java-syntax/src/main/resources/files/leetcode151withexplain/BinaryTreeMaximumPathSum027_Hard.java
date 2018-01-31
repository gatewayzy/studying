package _programming.leetcode151withexplain;

/**
 * 本题题意：寻找二叉树中的最大路径和，开始节点可以是任何节点 
 *
 *  本题的难点在于开始节点和结束节点可以任意。通过一个全局变量max记录住最大的路径和。
 *  
 *  maxSum函数返回的是当前节点值，以及当前节点加上左子树最大值，以及当前节点加上右子树最大值。
 *  然后最大值是通过记录当前节点加上左最大值和右最大值之后和记录中的最大值做比较。
 *  
 *  
 *  个人想法：这个题目可以从最底层想起，比如就三个节点，一个是父节点，一个左孩子一个右孩子，maxSum本身返回的是父节点，父节点+左孩子，父节点+右孩子里面的最大值。这个数值是提供给上层调用的时候，上层需要知道
 *  自己的做孩子和右孩子里面可以连接的最大值是多少，可以连接的概念是指是一条线。在maxsum里面会时刻当前节点作为根节点的树现在的最大路径会是什么。这个时候的值就是根节点加上非负的左孩子，加上非负的右孩子。
 *  
 */
public class BinaryTreeMaximumPathSum027_Hard {

	//二叉树节点
	class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	
	int max = Integer.MIN_VALUE;  
    
    public int maxSum(TreeNode root) {  
        if(root==null) {  
            return 0;  
        }  
          
        int  value  = root.val;  
        int  lmax = 0;  
        int  rmax = 0;  
        
        if(root.left != null) {  
            lmax = maxSum(root.left);  
            if(lmax>0) {  
                value  += lmax;  
            }  
        }  
          
        if(root.right != null) {  
            rmax = maxSum(root.right);  
            if(rmax > 0) {  
                value  += rmax;  
            }  
        }  
        //更新最大值  
        //max is the max of {root.val,root.val+lmax,root.val+rmax, root.val + lmax + rmax}  
        if (value > max) {  
            max = value;  
        }  
        //返回值  
        //return max of (root.val, root.val + lmax, root.val + rmax)  
        return  Math.max(root.val,Math.max(root.val + lmax, root.val + rmax));  
    }  
      
    
    public int maxPathSum(TreeNode root) {  
        if(root==null) {  
            return 0;  
        }  
        maxSum(root);  
        return max;  
    } 
}
