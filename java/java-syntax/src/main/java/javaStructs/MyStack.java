package javaStructs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**java stack and queue
 *
 */
public class MyStack {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		mystack();
		
		myqueue();
	}

	private static void mystack() {
		System.out.println("### stack...");
		Stack<Integer> stack = new Stack<>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println(stack.peek());
		
		// pop to retrieve and remove the head
		stack.pop();
		System.out.println(stack.pop());
		
		// peek to retrieve and do not remove the head
		stack.peek();
		System.out.println(stack.peek());
		
		System.out.println(stack.size() + "\t" + stack.isEmpty());
	}

	private static void myqueue() {
		System.out.println("### queue...");
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		System.out.println(queue.peek());

		// remove to remove the head
		queue.remove();
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		
		// peek to retrieve and do not remove
		queue.peek();
		System.out.println(queue.peek());

		// poll to retrieve and remove
		queue.poll();
		System.out.println(queue.peek());
		
		System.out.println(queue.size() + "\t" + queue.contains(1));
	}

}
