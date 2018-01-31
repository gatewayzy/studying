package _programming.leetcode151withexplain;

/**
 * 本题题意：给定一个链表，删除该链表从后面数的第k个元素
 * Given linked list: 1->2->3->4->5, and n = 2 the linked list becomes 1->2->3->5.
 *
 * 解题思路：链表经典算法，就是通过两个指针，这样便能够找到倒数的第k个元素。注意特殊情况，即倒数第k个元素正好是头节点；另外，循环遍历的时候判断的条件是aheadNode.next == null
 */
public class RemoveNthNodeFromEndofList132 {
	
	//链表的节点
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		     val = x;
		     next = null;
		 }
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		//两个指针，一个在前面，一个在后面
        ListNode aheadNode = head;
        ListNode afterNode = head;
        
        //前面的先行n步
        for(int i = 0; i < n;i++){
            aheadNode = aheadNode.next;
        }
        
        //如果aheadNode为空  这说明刚好到最后  那么从结尾数的第n个元素正好是头节点
        if(aheadNode == null){
            return head.next;
        }
        
        //如果不是，那么两个节点同事往后遍历,判断条件是aheadNode.next == null
        while(aheadNode.next != null){
            aheadNode = aheadNode.next;
            afterNode = afterNode.next;
        }
        
        //指针连接上
        afterNode.next = afterNode.next.next;
  
        return head;
    }
}
