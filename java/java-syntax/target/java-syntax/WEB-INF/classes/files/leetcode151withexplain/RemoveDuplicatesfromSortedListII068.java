package _programming.leetcode151withexplain;

/**
 * 本题题意：给出一个链表  删除所有重复节点
 * 
 *  For example,
	Given 1->2->3->3->4->4->5, return 1->2->5.
	Given 1->1->1->2->3, return 2->3.
	
	本题思路：
 *
 */
public class RemoveDuplicatesfromSortedListII068 {
	//链表节点  数据结构
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		     val = x;
		     next = null;
		 }
	}
	
	
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode answer = new ListNode(0);
        ListNode tempanswer = answer;
        ListNode leftNode = head;
        ListNode rightNode = head.next;
        //声明两个指针  依次遍历  
        while(leftNode != null && rightNode != null){
        	//当下一个指针和上一个指针相等的时候
            if(rightNode.val == leftNode.val){
            	//循环直到下一个节点不为null
                while(rightNode != null && rightNode.val == leftNode.val){
                    rightNode  = rightNode.next;
                }
                
                //如果现在的位置不是null，那么循环遍历
                if(rightNode != null){
                    leftNode = rightNode;
                    rightNode = leftNode.next;
                }else{
                	//设置leftnode为null
                    leftNode = null;
                }
            }else{
            	//不相等，那么就找到了一个点，加入结果链表中
                tempanswer.next = leftNode;
                tempanswer = tempanswer.next;
                
                leftNode = leftNode.next;
                rightNode = leftNode.next;
            }
        }
        
        if(leftNode != null && rightNode == null){
	         tempanswer.next = leftNode;
	         tempanswer = tempanswer.next;
	    }
        
	    tempanswer.next = null;
        
        return answer.next;
    }
}
