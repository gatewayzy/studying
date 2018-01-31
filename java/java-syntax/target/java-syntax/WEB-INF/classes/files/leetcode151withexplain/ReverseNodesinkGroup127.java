package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 * 本题题意：给出一个链表和k,把链表中每k个元素反转构建一个新的链表。
 * 
 *  For example,
	Given this linked list: 1->2->3->4->5
	For k = 2, you should return: 2->1->4->3->5
	For k = 3, you should return: 3->2->1->4->5
	
	希望用常量的空间。
	
	解题思路：通过一个栈来做倒叙排列。这儿是通过arraylist来模仿的，这样方便找到每一个元素。
 * 
 *
 */
public class ReverseNodesinkGroup127 {
	//链表的数据结构
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
	        val = x;
		    next = null;
	     }
	}
	
	
	public ListNode reverseKGroup(ListNode head, int k) {
		
        if(k == 0) return head;
        //特殊情况处理
        if(head == null) return head;
        if(head != null && head.next == null) return head;
        ListNode answer = new ListNode(0);
        ListNode connector = answer;
        int tempNum = 0;
        //use a stack to store the elements
        //模拟栈用于反转字符串
        ArrayList<ListNode> stack = new ArrayList<ListNode>();
        while(true){
            tempNum = 0;
            int i = k;
            //每次都遍历k个元素，然后加入到stack中
            for(; i > 0; i--){
            	//如果遇到为null的情况  直接跳出  也就是说不够k个元素的时候出现了
                if(head == null){
                    break;
                }else{
                    stack.add(head);
                    head = head.next;
                }
            }
            
            //正好找到了k个元素
            if(i == 0){
            	//倒转着连接到链表后面
                while(stack.size() != 0){
                    connector.next = stack.get(stack.size()-1);
                    connector = connector.next;
                    stack.remove(stack.size()-1);
                }
            }else{
            	//否则就顺序连接到链表后面
                while(stack.size() != 0){
                    connector.next = stack.get(0);
                    connector = connector.next;
                    stack.remove(0);
                }
                //别忘记了设置最后指向null
                connector.next = null;
                break;
            }
        }
        
        return answer.next;
    }
	
}
