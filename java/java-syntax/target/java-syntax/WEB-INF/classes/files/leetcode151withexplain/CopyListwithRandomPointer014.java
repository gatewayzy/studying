package _programming.leetcode151withexplain;

/**
 * 本题的题意就是有一个链表，每一个节点除了有一个指向下一个的指针，还有一个random指针，随机指向某一个节点。复制一份这个链表。而且不能改变原来的值。
 *
 * 解题思路：挺有技巧的   就是先在原来链表的每一个节点后面都复制一份这个节点；然后在复制所有的任意指针，此处复制的时候非常的巧妙，当前节点（原节点）的下一个节点的任意节点就等于当前节点的任意节点的下一个节点；
 * 然后再把链表恢复到原来的样子就可以了。
 */
public class CopyListwithRandomPointer014 {
	
	//randomlist节点数据结构
	class RandomListNode {
		 int label;
		 RandomListNode next, random;
		 RandomListNode(int x) { this.label = x; }
	};
	
	
	public RandomListNode copyRandomList(RandomListNode head) {  
        if (head == null) return null; 
        
        RandomListNode tempHead = head;  
        RandomListNode next = null; 
        
        //把链表的所有节点复制一份出来
        //Create the copy of every node in the list and insert   
        //it in original list between current and next node.     
        while (tempHead != null) {  
            RandomListNode n = new RandomListNode(tempHead.label);  
            next = tempHead.next;  
            tempHead.next = n;  
            n.next = next;  
            tempHead = next;  
        }  
        
        //把所有的任意指针复制一份
        RandomListNode newListHead = head.next;  
        //Copy the arbitrary link for result    
        tempHead = head;  
        while (tempHead != null) {
            if(tempHead.random != null){
                tempHead.next.random = tempHead.random.next;
            }
            if(tempHead.next != null){
                tempHead = tempHead.next.next;
            }
        }  
          
        //恢复到原来的结构
        tempHead = head;  
        RandomListNode temp = tempHead.next;  
        //restore the original and copy linked lists   
        while(tempHead != null && temp != null) {  
            tempHead.next = temp.next;  
            if (temp.next == null) {  
                break;  
            }  
            temp.next = temp.next.next;  
            tempHead = tempHead.next;  
            temp = temp.next;  
        }  
        return newListHead;       
    }  
}
