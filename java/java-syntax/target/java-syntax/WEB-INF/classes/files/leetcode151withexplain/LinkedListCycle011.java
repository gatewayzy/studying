package _programming.leetcode151withexplain;

/**
 * 本体是判断一个链表中是否存在环，那么就可以通过两个指针，一个走的快，一个走的慢，如果能够重合，那么就说明存在环
 * 
 *
 */
public class LinkedListCycle011 {

	class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	}
	
	public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        if(head.next == head){
            return true;
        }
        
        ListNode circleOrNotOne = head;
        ListNode circleOrNotTwo = head;
        //声明两个指针，一个一步一步的走，一个两步走。
        while(circleOrNotOne != null && circleOrNotTwo != null){
            circleOrNotOne = circleOrNotOne.next;
            //注意判断为空的情况
            if(circleOrNotTwo.next == null || circleOrNotTwo.next.next == null){
                return false;
            }
            circleOrNotTwo = circleOrNotTwo.next.next;
            if(circleOrNotTwo == circleOrNotOne){
                return true;
            }
        }
        
        return false;
    }
}
