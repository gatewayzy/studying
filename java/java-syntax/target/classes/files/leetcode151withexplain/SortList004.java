package _programming.leetcode151withexplain;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 * 题意：给出一个链表，在nlog(n)时间内进行排序，并且要求使用常量空间
 *
 * 解题思路：第二种方法比较好一些，就是根据归并排序的方式对两个链表进行排序。
 * 
 * 时间负责度为nlog(n)
 */
public class SortList004 {
	
		public static void main(String[] args){
			SortList004 object = new SortList004();
			ListNode head = new ListNode(2);
			ListNode node2 = new ListNode(1);
			head.next = node2;
			object.sortList2(head);
		}
	
	
		 //结构体 内部类
		 static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		     }
		  }

		/**
		 * 下面的解法比较无赖，就是先将ListNode中的值依次取出放在了List中，然后借助Collections进行排序，然后再把数值放到了链表中
		 * @param head
		 * @return
		 */
	    public ListNode sortList(ListNode head) {
	        if(head == null || head.next == null){
	            return head;
	        }
	        ListNode valuesNode = head;
	        List<Integer> values = new ArrayList<Integer>();
	        while(valuesNode != null){
	            values.add(valuesNode.val);
	            valuesNode = valuesNode.next;
	        }
	        
	        Collections.sort(values);
	        
	        ListNode resultNode = head;
	        for(int i = 0; i < values.size(); i++){
	            resultNode.val = values.get(i);
	            resultNode = resultNode.next;
	        }
	        
	        return head;
	        
	    }
	    
	    /*
	     * 以下是第二种方法，因为提到了复杂度是nlog(n)，所以想到了归并排序。两个链表的归并排序。
	     * 归并排序的核心是找到中间位置，然后递归调用归并排序，然后进行合并。 
	     * 在数组的归并排序中要要告诉开始下标和结束下标，但是在merge的时候需要申请空间来存储中间结果
	     * 链表的方式就只需要指针的移动，所以节省了空间，但是两个链表进行合并的时候，必须知道在哪结束的，所以，找到中间位置之后要设置为null.就是认为的给弄成两个链表。
	     */
	    public ListNode sortList2(ListNode head) {
	        if(head == null || head.next == null){
	            return head;
	        }
	        return mergeSort(head);
	    }
	    
	    public ListNode mergeSort(ListNode head){
	        if(head == null || head.next == null) return head;
	        
	        //find mid
	        ListNode slow = head;
	        ListNode fast = head;
	        ListNode pre = null;
	        while(fast != null && fast.next != null){
	            pre = slow;
	        	slow = slow.next;
	            fast = fast.next.next;
	        }
	        
	        pre.next = null;
	        ListNode left = mergeSort(head);
	        ListNode right = mergeSort(slow);
	        
	        return merge(left,right);
	    }
	    
	    public ListNode merge(ListNode left,ListNode right){
	        ListNode answer = new ListNode(0);
	        ListNode temp  = answer;
	        while(left != null && right != null){
	            if(left.val < right.val){
	                temp.next = left;
	                left = left.next;
	                temp = temp.next;
	            }else{
	                temp.next = right;
	                right = right.next;
	                temp = temp.next;
	            }
	        }
	        
	        if(left != null){
	            while(left != null){
	                temp.next = left;
	                left = left.next;
	                temp = temp.next;
	            }
	        }
	        
	        if(right != null){
	            while(right != null){
	                temp.next = right;
	                right = right.next;
	                temp = temp.next;
	            }
	        }
	        
	        temp.next = null;
	        return answer.next;
	        
	    }
}
