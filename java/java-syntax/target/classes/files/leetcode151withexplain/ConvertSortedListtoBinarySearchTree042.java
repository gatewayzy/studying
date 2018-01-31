package _programming.leetcode151withexplain;

/**
 *  本题题意：将升序排列的数组变为平衡二叉搜索树
 *  
 *  二叉搜索树：每一个几点的左子树都小于自己，右子树数组都大于自己。  二叉搜索数的特性：按中序遍历获得的便是一个升序数组
 *
 *  本题解题思路：每一个数组的中间位置就是根节点，左边就是它的左子树，右边就是它的右子树。然后通过递归来实现。
 */
public class ConvertSortedListtoBinarySearchTree042 {

	 //链表节点数据结构
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; next = null; }
	 }
	 
     //树节点的数据结构
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
	 public TreeNode sortedListToBST(ListNode head) {  
	        int length = 0;  
	        ListNode node = head;  
	        while(node!=null){  
	            node = node.next;  
	            length++;  
	        }  
	        return sortedListToBST(head, length);  
	 }  
	 
	//出入的是链表的头结点和链表的长度 
    private TreeNode sortedListToBST(ListNode head, int length){
    	
    	//特殊情况处理
        if(length == 0 || head == null){  
            return null;  
        }else if(length == 1){  
            return new TreeNode(head.val);  
        }  
  
        ListNode peak = head;  
        //找到中间位置
        int index = (int)(length/2);  
        for(int i = 0; i<index; i++){  
            peak = peak.next;  
        }  
        
        //设置当前节点的左右子树
        TreeNode node = new TreeNode(peak.val);  
        node.left = sortedListToBST(head, index);  
        node.right = sortedListToBST(peak.next, length - index - 1);  
          
        return node;  
    }
}
