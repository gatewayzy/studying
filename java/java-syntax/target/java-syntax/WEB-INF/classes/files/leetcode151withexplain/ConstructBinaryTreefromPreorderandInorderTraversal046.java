package _programming.leetcode151withexplain;


/**
 * 给出先序遍历和中序遍历  然后构建树
 * 
 * 先序遍历特点：第一个点就是对应树的根节点
 *
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal046 {
	//树节点的数据结构
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        
        TreeNode result = buildDetail(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return result;
        
    }
    
    //recursive
    public TreeNode buildDetail(int[] preorder, int prebegin, int preend,int[] inorder,int inbegin,int inend){
        if(prebegin > preend){
            return null;
        }
        
        int preorderFirst = preorder[prebegin];
        int inorderPosition = 0;
        for(int i = inbegin; i <= inend; i++){
            if(inorder[i] == preorderFirst){
                inorderPosition = i;
                break;
            }
        }
        
        int len = inorderPosition - inbegin;
        
        TreeNode root = new TreeNode(preorderFirst);
        root.left = buildDetail(preorder, prebegin+1, prebegin+len,inorder,inbegin,inorderPosition-1);
        root.right = buildDetail(preorder, prebegin+len+1, preend,inorder,inorderPosition+1,inend);
        
        return root;
        
        
    }
}
