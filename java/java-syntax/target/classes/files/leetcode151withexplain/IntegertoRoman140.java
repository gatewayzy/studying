package _programming.leetcode151withexplain;

/**
 * 本题题意：给出一个整数，返回其对应的罗马字符串
 * 
 * 解题思路：
 *  
 */
public class IntegertoRoman140 {
	
	public String intToRoman(int num) {
		//用两个数组记录住对应关系
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] romanNums = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		
		//用stringbuilder来做这件事情
		StringBuilder stringBuilder = new StringBuilder();
		//遍历values里面每一个元素，如果现有的数字超越了所需要数字，那么增加上对应的罗马字符
		for(int i = 0; i < values.length; i++){
			//这儿是一个循环关系，因为尽可能多的增加上对应的罗马字符
			while(num >= values[i]){
				stringBuilder.append(romanNums[i]);
				num = num - values[i];
			}
		}
		return stringBuilder.toString();
    }
}
