package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 * 本题题意：给出k个有序的链表，合并k个链表。返回结果。分析其时间复杂度和空间复杂度。
 * 
 * 解题思路：遍历每一个链表，轮番打擂台，获取最后的结果。
 *
 *
 */
public class MergekSortedLists129 {
	
	//链表节点  数据结构
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
			 val = x;
		     next = null;
		 }
	}
	
	//遍历lists里面的每一个链表   轮询着做链表的合并
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
        int listsSize = lists.size();
        if(listsSize == 0) return null;
        if(listsSize == 1) return lists.get(0);
        ListNode currentNode = null;
        for(int i = 0; i < listsSize; i++){
            currentNode = mergeTowList(currentNode,lists.get(i));
        }
        
        return currentNode;
    }
    
    public ListNode mergeTowList(ListNode one, ListNode two){
        if(one == null) return two;
        if(two == null) return one;
        
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while(one != null && two != null){
            if(one.val <= two.val){
                temp.next = one;
                one = one.next;
                temp = temp.next;
            }else{
                temp.next = two;
                two = two.next;
                temp = temp.next;
            }
        }
        
        if(one != null){
            temp.next = one;
        }
        
        if(two != null){
            temp.next = two;
        }
        
        return result.next;
    }
}
