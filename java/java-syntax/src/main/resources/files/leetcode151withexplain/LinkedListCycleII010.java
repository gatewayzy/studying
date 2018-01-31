package _programming.leetcode151withexplain;

/**
 * 本题是返回带环链表中环的起始点   这个是一个数学问题，可以先通过一个快指针和一个慢指针找到第一次相等的位置。然后从第一次重叠的位置开始，另一个指针从head
 * 处开始，当两个指针相等的时候，即时入环的第一个节点。
 * 
 *  当然了，也可以通过map来做，找到第一次重复的元素。
 *
 */
public class LinkedListCycleII010 {
	class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	}
	
	public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        
        if(head.next == head){
            return head;
        }
        
        if(head.next == null){
            return null;
        }
        
        ListNode circleOrNotOne = head;
        ListNode circleOrNotTwo = head;
        while(circleOrNotOne != null && circleOrNotTwo != null){
            circleOrNotOne = circleOrNotOne.next;
            if(circleOrNotTwo.next == null || circleOrNotTwo.next.next == null){
                return null;
            }
            circleOrNotTwo = circleOrNotTwo.next.next;
            
            if(circleOrNotOne == circleOrNotTwo){
                break;
            }
        }
        
        //以上代码是找到了第一次重叠的点，然后下面就是一种数学思路解决
        ListNode firstCrossPoint = circleOrNotOne;
        while(head != firstCrossPoint){
            head = head.next;
            firstCrossPoint = firstCrossPoint.next;
        }
        
        return head;
    }
}
