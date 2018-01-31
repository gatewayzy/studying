package _programming.leetcode151withexplain;

/**
 * 本题题意：给出一个链表指针  链表中有重复的节点，去掉重复节点，只剩下一个就可以
 * 
 *  For example,
	Given 1->1->2, return 1->2.
	Given 1->1->2->3->3, return 1->2->3.
	
	本题思路：通过两个指针   一个记录前面的节点  一个记录下面一个不重复的节点  然后依次往后遍历  移动指针就可以了
 *
 */
public class RemoveDuplicatesfromSortedList069 {
	
	//链表节点  数据结构
    public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		    val = x;
		    next = null;
		 }
	 }
    
    //消除重复节点
    public ListNode deleteDuplicates(ListNode head) {
       	if(head == null || head.next == null){
    		return  head;
    	}
    	
       	//用两个节点往后遍历，preNode记录前面的元素，nextNode记录下一个非重复的元素
    	ListNode preNode = head;
    	ListNode nextNode = head;
    	//preNode和下一个node都不会空
    	while(preNode != null && preNode.next != null){
    		nextNode = preNode.next;
    		while((nextNode != null) && (nextNode.val == preNode.val)){
    			nextNode = nextNode.next;
    		}
    		preNode.next = nextNode;
    		if(preNode != null){
    			preNode = preNode.next;
    		}
    	}
    	
        return head;     
    }
}
