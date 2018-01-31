package _programming.instance;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * 使用stack计算字符串表达式
 * @author dell
 *
 */
public class CalWithStack {

	public static void main(String[] args) {
		String string = null;
		Scanner scanner = new Scanner(System.in);

		Set<String> sym = new HashSet<>();
		sym.add("+");
		sym.add("-");
		sym.add("*");

		Stack<Integer> stack = new Stack<>();

		// 判断是否有输入
		while (scanner.hasNextLine()) {
			string = scanner.nextLine();

			for (int i = 0; i < string.length(); i++) {

				char achar = string.charAt(i);
				int inInt = 0;
				int ret = 0;

				if (achar == '+') {
					ret = stack.pop() + stack.pop();
					stack.push(ret);
				} else if (achar == '-') {
					ret = -stack.pop() + stack.pop();
					stack.push(ret);
				} else if (achar == '*') {
					ret = stack.pop() * stack.pop();
					stack.push(ret);
				} else {

					if (achar >= '0' && achar <= '9') {
						inInt = achar - '0';
					} else if (achar >= 'A' && achar <= 'F') {
						inInt = achar - 'A' + 10;
					} else if (achar >= 'a' && achar <= 'f') {
						inInt = achar - 'a' + 10;
					}
					stack.push(inInt);
				}

				//System.out.println(stack.peek());

			}
			System.out.println(stack.peek());
		}

		scanner.close();
	}

}
