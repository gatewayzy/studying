package _programming.leetcode151withexplain;

/**
 *  本题题意：给出一个链表和x,把所有小于X的节点放到左边，大于x的节点放到右边
 *  
 *  本题思路；通过两个链表记录住小于和大于的数值，然后连接到一起就可以了。
 * 
 *  For example,
	Given 1->4->3->2->5->2 and x = 3,
	return 1->2->2->4->3->5.
 *
 */
public class PartitionList065 {
	
	//链表节点   数据结构
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		     val = x;
		     next = null;
		 }
	}
	
	 public ListNode partition(ListNode head, int x) {
		 
		 	//特殊情况处理
	        if(head == null || head.next == null){
	            return head;
	        }
	        
	        int lessNum = 0;
	        int moreNum = 0;
	        
	        //声明四个指针  分别用于记录   小于x的节点和大于x的节点
	        ListNode lessNodeHead = new ListNode(0);
	        ListNode lessNodeTail = new ListNode(0);
	        ListNode moreNodeHead = new ListNode(0);
	        ListNode moreNodeTail = new ListNode(0);
	        
	        //循环遍历这个链表  把对应的节点加入到对应的链表中
	        while(head != null){
	        	//对于头结点要特殊处理
	            if(head.val < x && lessNum == 0){
	                lessNodeTail = head;
	                lessNodeHead = lessNodeTail;
	                lessNum++;
	                head = head.next;
	                continue;
	            //采用后插入法 在链表后面插入元素
	            }else if(head.val < x && lessNum > 0){
	                lessNodeTail.next = head;
	                lessNodeTail = lessNodeTail.next;
	                lessNum++;
	            }
	            
	            if(head.val >= x && moreNum == 0){
	                moreNodeTail = head;
	                moreNodeHead = moreNodeTail;
	                moreNum++;
	                head = head.next;
	                continue;
	            }else if(head.val >= x && moreNum > 0){
	                moreNodeTail.next = head;
	                moreNodeTail = moreNodeTail.next;
	                moreNum++;
	            }
	            
	            head = head.next;
	        }
	        //设置后面为空
	        moreNodeTail.next = null;
	        
	        //特殊情况处理
	        if(lessNum > 0 && moreNum > 0){
	            lessNodeTail.next = moreNodeHead;
	        }else if(lessNum == 0 && moreNum > 0){
	            return moreNodeHead;
	        }
	        return lessNodeHead;
	   }
}
