package _programming.leetcode151withexplain;

/**
 * 本题题意：合并两个有序的列表，其实和合并两个有序的数组差不多 
 * 
 * 解题思路：其实就是和合并两个数组差不多   别忘了后面剩余的部分就好
 *
 */
public class MergeTwoSortedLists088 {
	//链表节点
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
			 val = x;
			 next = null;
		 }
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		//声明一个头节点
        ListNode result = new ListNode(0);
        ListNode tempNode = result;
        //依次遍历两个链表里面的每一个节点
        while(l1 != null && l2 != null){
            
            if(l1.val <= l2.val){
                tempNode.next = l1;
                tempNode = tempNode.next;
                l1 = l1.next;
            }else{
                tempNode.next = l2;
                tempNode = tempNode.next;
                l2 = l2.next;
            }
        }
        
        //别忘了剩余部分
        if(l1 != null){
            tempNode.next = l1;
        }
        
        if(l2 != null){
            tempNode.next = l2;
        }
        
        return result.next;
	 }
}
