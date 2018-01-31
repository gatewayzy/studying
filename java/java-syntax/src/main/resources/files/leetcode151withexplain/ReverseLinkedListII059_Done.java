package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 *  本题题意：给出一个链表  将指定m到n之间的节点进行反转 
 *
 *  For example:
	Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	return 1->4->3->2->5->NULL.
	
	一般思路：通过栈来实现  对于介于m和n之间的数据压入栈，然后弹出后连接到链表后面 
 */
public class ReverseLinkedListII059_Done {
	
	//链表节点
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		     val = x;
		     next = null;
		 }
	}
	
	 public ListNode reverseBetween(ListNode head, int m, int n) {
	        
	        if(head == null) return head;
	        if(head.next == null) return head;
	        
	        //act as stack to store numbers
	        ArrayList<ListNode> likeQueue = new ArrayList<ListNode>();
	        
	        
	        //把m和n之间的数据压入到栈中
	        int i = 1;
	        ListNode tempHead = head;
	        while(tempHead != null){
	            
	            if(i >= m && i <= n){
	                likeQueue.add(tempHead);
	            }
	            
	            i++;
	            tempHead = tempHead.next;
	        }
	        
	        
	        //同时遍历原链表和栈里面的数据   在m和n之间的时候  就连接栈中的数据
	        int j = 1;
	        ListNode anotherHead = new ListNode(0);
	        ListNode newHead = anotherHead;
	        while(head != null){
	            
	            if(j >= m && j <= n){
	            	anotherHead.next = new ListNode(likeQueue.get(likeQueue.size()-1).val);
	            	likeQueue.remove(likeQueue.size()-1);
	            }else{
	            	anotherHead.next = new ListNode(head.val);
	            }
	            
	            anotherHead = anotherHead.next;
	            j++;
	            head = head.next;
	        }
	        
	        return newHead.next;
	   }
	
	   //通过四个指针  
	   public ListNode reverseBetween1(ListNode head, int m, int n) {
	        ListNode before = null, start, end, after = null;
	        ListNode ptr = head;
	        
	        //求出before
	        for(int i = 1; i < m; i++){
	            before = ptr;
	            ptr = ptr.next;
	        }
	        
	        start = end = ptr;
	        //通过前部插入实现反转
	        for(int i = m; i <= n; i++){
	            after = ptr.next;
	            ptr.next = end;
	            end = ptr;
	            ptr = after;
	        }
	        
	        //特殊情况处理
	        if(before == null){
	            head = end;
	        }else{
	        	before.next = end;
	        }
	        
	        start.next = after;
	        return head;
	    }
}
