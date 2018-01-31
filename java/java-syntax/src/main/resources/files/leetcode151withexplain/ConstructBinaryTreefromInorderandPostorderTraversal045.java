package _programming.leetcode151withexplain;

/**
 *  本题题意：给出一棵树的中序遍历和后续遍历  构建这棵树
 *  
 *  解题思路：
 *  中序遍历的特点是；根节点左边的数据便是它的左子树节点，根节点的右边的数据便是它的右子树节点。
 *  后序遍历的特点是：根节点后序遍历的最后一个节点。
 *  
 *  先从后序遍历中获取最后一个节点，也就是获得了整棵树的根节点；然后从中序遍历中获得这个节点的位置，那么就知道了其左子树节点和右子树节点们。那么后序遍历的前面部分也是左子树的后续遍历，后续遍历
 *  的后面部分也是右子树的后续遍历部分。（因为肯定是先遍历左边再遍历它右边）
 *  
 *  通过递归调用，就可以构建出这么一棵树。
 *
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal045 {
	//树节点的数据结构
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0){
            return null;
        }
        
        TreeNode result = buildDetail(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
        return result;
    }
    
    //递归构建树  指标一共有六个  给出遍历的开始位置和结束位置
    public TreeNode buildDetail(int[] inorder, int inbegin,int inend, int[] postorder,int postbegin,int postend){
        
    	//边界条件
        if(inbegin > inend){
            return null;
        }
        
        int postLast = postorder[postend];
        
        //从中序遍历中找到根节点位置
        int inorderPosition = 0;
        for(int i = inbegin; i <= inend; i++){
            if(inorder[i] == postLast){
                inorderPosition = i;
                break;
            }
        }
        int len = inorderPosition - inbegin;
        
        //递归调用  构建树
        TreeNode root = new TreeNode(postLast);
        root.left = buildDetail(inorder, inbegin,inbegin+len-1, postorder,postbegin,postbegin+len-1);
        root.right = buildDetail(inorder, inbegin+len+1,inend, postorder,postbegin+len,postend-1);
        
        return root;
        
    }
}
