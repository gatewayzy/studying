package _programming.leetcode151withexplain;

/**
 * 本题题意：给出一个链表 对于链表中紧挨着的两个元素进行反转 返回新的链表
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * 解题思路：通过三个指针来做，两个指针用于记录当前需要转换方向的两个指针；另外一个指针用于记录前面反转后的最后一个指针。这样连绵下去，
 * 便可以实现链表的节点的反转。
 * 
 */
public class SwapNodesinPairs128 {

	// 链表节点的数据结构
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode swapPairs(ListNode head) {
		// 特殊情况处理
		if (head == null)
			return null;
		if (head != null && head.next == null)
			return head;

		// 第一个节点
		ListNode startNode = head;
		// 第二个节点
		ListNode endNode = head.next;
		// 结果节点 指向第二个节点
		ListNode result = endNode;
		// lastNode记住上一轮的最后一个元素
		ListNode lastNode;

		// 先反转前两个节点
		startNode.next = endNode.next;
		endNode.next = startNode;

		lastNode = startNode;

		// 对于连表中的两个节点 依次反转
		while (startNode.next != null && startNode.next.next != null) {
			startNode = startNode.next;
			endNode = startNode.next;

			startNode.next = endNode.next;
			endNode.next = startNode;

			lastNode.next = endNode;

			lastNode = startNode;

		}

		// 如果出现特殊情况，那么就直接加到后面就行了
		if ((startNode.next != null) && (startNode.next.next == null)) {
			lastNode.next = startNode.next;
		}

		return result;
	}
}
