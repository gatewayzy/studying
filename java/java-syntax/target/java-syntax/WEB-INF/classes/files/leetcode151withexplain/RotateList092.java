package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;

/**
 * 本题题意：给出一个链表和数字k,将链表右边的k个元素反转到前面 
 *
 * 解题思路：用两个指针，一个指针先往前面走n步（这个存在循环设置问题），而后两个指针一起往后走，当一个结束的时候，另一个就到了要求的位置。然后前后连接就可以了。
 */
public class RotateList092 {
	
	//链表节点  数据结构
	static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		      val = x;
		      next = null;
		 }
	}
	
	public ListNode rotateRight(ListNode head, int n) {
		
        ListNode  first = head;
        ListNode  second = head;
        ListNode  result = null;
    
        if(head == null) {
            return result;
        }
    
        int i = 0;
        //先往前走n步，如果链表中元素数目小于n,那么就循环从头获取
        while(i < n) {
            if(first.next != null) {
                first = first.next;
            }
            else {
                first = head;
            }
            i++;
        }
    
        //first指针比较快，往前走了k步 ，现在一起走，那么当first为空的时候，second距离结束也有k个字符
        //判断条件是first.next
        while(first.next != null) {
            first = first.next;
            second = second.next;
        }
    
        //如果second的下一个不会空，那么结果应该从seconde的下一个开始 
        if(second.next != null) {
            result = second.next;
        }
        else {
            result = head;
        }
    
        
        first.next = head;
        second.next = null;
    
        return result;
   }
	
	
	public static void main(String[] args){
		ListNode node0 = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		
		List<ListNode> list = new ArrayList<ListNode>();
		list.add(node0);
		list.add(node1);
		
		node1.val = 4;
		
		node1.next = node3;
		
		
		node1 = node1.next;
	}
	
}
