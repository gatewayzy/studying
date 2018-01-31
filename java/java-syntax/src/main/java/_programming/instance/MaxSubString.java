package _programming.instance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author dell
 *
 */
public class MaxSubString {
	//Produces a printable string representation of a dictionary
	//784
	//output: string

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String dictionary = input.nextLine();
		String number = input.nextLine();
		input.close();

		// 字典转化为数字
		// 1. 字典拆分
		String[] dicEnArr = dictionary.split(" ");
		List<String> dicEnList = new ArrayList<>();
		for (int i = 0; i < dicEnArr.length; i++) {
			dicEnList.add(dicEnArr[i].toLowerCase());
		}
		// 2. 英文转换为数字
		List<String> dicDiList = new ArrayList<>();
		for (int i = 0; i < dicEnArr.length; i++) {
			dicDiList.add(str2Di(dicEnList.get(i)));
			//System.out.println(str2Di(dicEnList.get(i)));
		}
		
		List<Integer> maxLenList = new ArrayList<>();
		for (int i = 0; i < dicEnArr.length; i++) {
			maxLenList.add(i,  getLCString(dicDiList.get(i).toCharArray(), number.toCharArray()));
		}
		
		// 输出
		int maxLen = 0;
		int ret = 0;
		for (int i = 0; i < dicEnArr.length; i++) {
			if (maxLenList.get(i)>maxLen) {
				maxLen = maxLenList.get(i);
				ret = i;
				//System.out.println(max);
				//System.out.println(dicEnArr[i]);
			}
		}
		System.out.println(dicEnArr[ret]);
	}

	private static String str2Di(String enString) {
		StringBuilder sBuilder = new StringBuilder();
		char[] charArr = enString.toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			sBuilder.append(char2Di(charArr[i]));
		}
		return sBuilder.toString();
	}

	private static char char2Di(char c) {
		if (c < 'd') {
			return 2 + '0';
		} else if (c < 'g') {
			return 3 + '0';
		} else if (c < 'j') {
			return 4 + '0';
		} else if (c < 'm') {
			return 5 + '0';
		} else if (c < 'p') {
			return 6 + '0';
		} else if (c < 't') {
			return 7 + '0';
		} else if (c < 'w') {
			return 8 + '0';
		} else
			return 9 + '0';
	}
	
	// 在动态规划矩阵生成方式当中，每生成一行，前面的那一行就已经没有用了，因此这里只需使用一维数组，而不是常用的二位数组
		private static int getLCString(char[] str1, char[] str2) {
			int len1, len2;
			len1 = str1.length;
			len2 = str2.length;
			int maxLen = len1 > len2 ? len1 : len2;

			int[] max = new int[maxLen];// 保存最长子串长度的数组
			int[] maxIndex = new int[maxLen];// 保存最长子串长度最大索引的数组
			int[] c = new int[maxLen];

			int i, j;
			for (i = 0; i < len2; i++) {
				for (j = len1 - 1; j >= 0; j--) {
					if (str2[i] == str1[j]) {
						if ((i == 0) || (j == 0))
							c[j] = 1;
						else
							c[j] = c[j - 1] + 1;// 此时C[j-1]还是上次循环中的值，因为还没被重新赋值
					} else {
						c[j] = 0;
					}

					// 如果是大于那暂时只有一个是最长的,而且要把后面的清0;
					if (c[j] > max[0]) {
						max[0] = c[j];
						maxIndex[0] = j;

						for (int k = 1; k < maxLen; k++) {
							max[k] = 0;
							maxIndex[k] = 0;
						}
					}
					// 有多个是相同长度的子串
					else if (c[j] == max[0]) {
						for (int k = 1; k < maxLen; k++) {
							if (max[k] == 0) {
								max[k] = c[j];
								maxIndex[k] = j;
								break; // 在后面加一个就要退出循环了
							}
						}
					}
				}
				/*
				 * for (int temp : c) { System.out.print(temp); }
				 * System.out.println();
				 */
			}
			// 打印最长子字符串
			/*
			 * for (j = 0; j < maxLen; j++) { if (max[j] > 0) {
			 * System.out.println("第" + (j + 1) + "个公共子串:"); for (i = maxIndex[j] -
			 * max[j] + 1; i <= maxIndex[j]; i++) System.out.print(str1[i]);
			 * System.out.println(" "); System.out.println(max[j]); } }
			 */
			return max[0];
		}


}
