package _programming.leetcode151withexplain;

/**
 * 对链表进行插入排序，和之前提到的对链表进行归并排序差不多，都是把传统数组的操作应用到了链表上面。
 * 
 * 尝试了很久，如果不是采用值的交换，而是直接就用指针的改变，相当的麻烦和复杂。
 * 
 * 解题思路：模拟数组的插入排序，即外层循环从第二个元素往后面扫描，内存循环是从开始元素到最外层当前元素。只是在连表中当发现插入的位置的时候，本题中也是通过不断的交换数值来实现的。
 * 
 * 时间复杂度：O（n^2）  插入排序最好是O（n）
 *
 */
public class InsertionSortList005 {
	
	public static void main(String[] args){
		InsertionSortList005 object = new InsertionSortList005();
		ListNode head = new ListNode(5);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(1);
		
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		object.insertionSortList(head);
	}
	
	//数据结构
	public static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	         val = x;
	         next = null;
	    }
	}
	
	
	 public ListNode insertionSortList(ListNode head) {
	        if(head == null || head.next == null) return head;
	        
	        //模拟数组的插入排序
	        ListNode i = head.next;
	        while(i != null){
	            ListNode j = head;
	            //通过循环找到插入位置
	            while(j.val < i.val && j != i){
	                j = j.next;
	            }
	            
	            //如果如果找到插入位置，那么就不断的往后移动链表节点上面的数值
	            if(j != i){
	                int ivalue = i.val;
	                int jvalue;
	                while(j != i){
	                    jvalue = j.val;
	                    j.val = ivalue;
	                    ivalue = jvalue;
	                    j = j.next;
	                }
	                j.val = ivalue;
	            }
	            
	            
	            i = i.next;
	        }
	        
	        return head;
	    }
}
