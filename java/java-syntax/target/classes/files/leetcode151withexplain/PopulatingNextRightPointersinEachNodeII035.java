package _programming.leetcode151withexplain;


/**
 * 本题题意：和34题类似  只是现在的树不再是满二叉树  而是任意二叉树都可以
 * 
 * 解题思路：
 * 通过上层的遍历，找到自己的左右孩子要指向的位置；即找到笨节点的next的左右孩子，然后设置该节点的左右孩子的next指向。
 * 
 * 然后递归调用该方法。
 * 
 * 注意点：从右向左
 *
 */
public class PopulatingNextRightPointersinEachNodeII035 {

	//数据结构  三个指针  左右子树和下一个
		public class TreeLinkNode {
			 int val;
			 TreeLinkNode left, right, next;
			 TreeLinkNode(int x) { val = x; }
		}
	
	 public void connect(TreeLinkNode root) {
	        
	        if(root == null){
	            return;
	        }
	        
	        TreeLinkNode currentNode = root.next;
	        
	        //用于找到下一个节点位置
	        TreeLinkNode nextPoint = null;
	        
	        while(currentNode != null){
	        	//先左   后右
	            if(currentNode.left != null){
	                nextPoint = currentNode.left;
	                break;
	            }
	            
	            if(currentNode.right != null){
	                nextPoint = currentNode.right; 
	                break;
	            }
	            currentNode = currentNode.next;
	        }
	        
	        //设置右孩子的指向
	        if(root.right != null){
	            root.right.next = nextPoint;
	        }
	        
	        //设置左孩子指向  这个时候要考虑自己的右孩子是否为空
	        if(root.left != null){
	            root.left.next = root.right != null? root.right:nextPoint;
	        }
	 
	        //递归调用该方法  从右子向左使用
	        connect(root.right);
	        connect(root.left);
	 
	    }
}
