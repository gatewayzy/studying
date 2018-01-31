package _programming.leetCode;

/*
 * 本题题意：给出两个链表，求出两个链表所代表的数字的和。链表的头部代表最低位。
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
   Output: 7 -> 0 -> 8
   
          解题思路：一种方法是先转换成数字的加法，生成答案，注意要使用BigInteger
          另一种是进行节点遍历加法
 * 
 */
/**
 * medium
 * 
 * @author dell
 *
 */
public class $002AddTwoNum {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(4);
		// ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(5);
		// ListNode l5 = new ListNode(6);
		// ListNode l6 = new ListNode(4);
		// l1.next = l2;
		// l2.next = l3;
		// l4.next = l5;
		// l5.next = l6;

		ListNode ret = new SolutionAddTwoNum().addTwoNumbers(l1, l4);
		while (ret != null) {
			System.out.println(ret.val);
			ret = ret.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;// higher node

	public ListNode(int val) {
		this.val = val;
	}
}

/*
 * 下面的方法是 1. 首先是null的话特殊处理 2. 对于两个从低位开始循环处理 创建当前的数字之和为节点，一直循环直到均为null
 * 下一节点计算出来后，创建当前节点，并设置上一个节点连到当前点 均为null时需要考虑是否还有进位 为方便长度统一可以将为null的位补0
 *
 */
class SolutionAddTwoNum {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		/***/

		// special
		if (l1 == null && l2 != null) {
			return l2;
		}
		if (l1 != null && l2 == null) {
			return l1;
		}
		if (l1 == null && l1 == null) {
			return null;
		}

		// add
		ListNode ret = null;
		int carry = 0;
		int current = 0;
		ListNode tmpcu = null;
		ListNode tmppre = null;
		for (int i = 0;; i++) {
			current = l1.val + l2.val + carry;
			carry = current / 10;
			current = current % 10;

			if (i == 0) {
				ret = new ListNode(current);// set head
				tmppre = ret;
				ret.next = tmpcu;
			} else {
				tmpcu = new ListNode(current);// set next
				tmppre.next = tmpcu; // set pre.next
				tmppre = tmpcu; // reset pre
			}

			l1 = l1.next;
			l2 = l2.next;

			if (l1 == null && l2 == null) {
				if (carry != 0) {
					l1 = new ListNode(0);
				} else {
					break;
				}
			}
			if (l1 == null) {
				l1 = new ListNode(0);
			}
			if (l2 == null) {
				l2 = new ListNode(0);
			}
		}

		return ret;
	}
	/***/
}
