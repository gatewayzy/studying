package _programming.leetcode151withexplain;

/**
 * 本题题意：给出一个罗马数字的字符串，转换为数字
 * 
 * 本题思路：通过两个字符串记录住数字和罗马字符之间的对应关系。然后从头往后遍历字符串s,然后当摘到对应的字符时，增加响应的数字就可以了。这个应该有优先级关系，先出现什么就加什么数据。
 *
 */
public class RomantoInteger139 {
	
	public int romanToInt(String s) {
		//两个数组记录住这个对应关系
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] romanNums = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

		//从头开始遍历字符串s
		int result = 0;
		for(int i = 0; i < s.length() ;){
			
			//遍历romanNums里面的每一个位置，看是否s中存在
			for(int j = 0; j < romanNums.length; j++){
				//获取romanLength
				int romanLength = romanNums[j].length();
				//如果后面剩余的字符串还满足要求，还能找到所需的字符串
				if((s.length() - i >= romanLength) && s.substring(i,i+romanLength).equals(romanNums[j])){
					result += values[j];
					i = i+romanLength;
					break;
				}
				
			}
		}
		
		return result;
	}
}
