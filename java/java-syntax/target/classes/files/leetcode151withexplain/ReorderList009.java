package _programming.leetcode151withexplain;

import java.util.ArrayList;

/*
 * 本题题意就是给出一个链表，然后通过交换
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
   reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→… 
 */
public class ReorderList009 {
	
	//数据结构
	class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
	}
	
	public void reorderList(ListNode head) {
        
        if(head == null){
            return;
        }
        
        if(head != null && head.next == null){
            return;
        }
        
        ArrayList<ListNode> onetolast = new ArrayList<ListNode>();

        //下面的循环就是讲所有的节点放到onetolast中
        ListNode tempHead = head;
        int listLength = 0;
        while(tempHead != null){
            onetolast.add(tempHead);    
            tempHead = tempHead.next;
            listLength++;
        }
        
        
        ListNode result = new ListNode(0);
        ListNode answer = result;
        int i = 0;
        //然后分别从onetolast的前后取值，拼成所需的链表
        for(int j = 0; j < listLength; j++){
            result.next = onetolast.get(j);
            result = result.next;
            //随时记录现在节点的个数  当节点的个数等于总节点数的时候，也就是现在不用继续往后面增加节点了，那么声明后续为null就行了
            i++;
            if(i == listLength){
            	result.next = null;
            	break;
            }
            result.next = onetolast.get(listLength-1-j);
            result = result.next;
            i++;
            if(i == listLength){
            	result.next = null;
            	break;
            }
        }
        
        head = answer.next;
    }
}
