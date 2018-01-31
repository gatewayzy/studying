package _programming.leetcode151withexplain;

import java.util.HashMap;
import java.util.Map;

/**
 * 本题题意：给出一个字符串，找到该字符串中包含有非重复字符的最长子串长度。
 * 
 *	For example,  "abcabcbb" is "abc", which the length is 3. 
 *	For "bbbbb" the longest substring is "b", with the length of 1.
 *
 *	解题思路：通过一个map记录住每一个字符的位置，用idx记录基准位置，也就是当前位置和idx位置之间没有重复元素。对于每一个元素，如果之前已经出现过一次，如果上次的位置大于idx，那么就要更新idx，然后求出
 *  范围值。求出最新的answer就可以了。
 */
public class LongestSubstringWithoutRepeatingCharacters149 {
	
	
	public static void main(String[] args){
		LongestSubstringWithoutRepeatingCharacters149 object = new LongestSubstringWithoutRepeatingCharacters149();
		object.lengthOfLongestSubstring("abcdeba");
	}
	
	
	 
	public int lengthOfLongestSubstring(String s) {
		//用一个map记录住每一个元素的开始位置
         Map<String,Integer> strPositionMap = new HashMap<String,Integer>();
         int sLength = s.length();
         //idx初始值设置为-1
         int idx = -1;
         int answer = 0;
         
         //遍历每一个元素  看该元素是否存在于map中
         for(int i = 0; i < sLength; i++){
             
        	 //如果存在  而且字符开始位置大于上一次出现的位置   那么idx重新赋值
        	 //思路就是现在遇到了一个重复的元素，那么就要知道上一个重复出现的位置是哪，如果这个位置超过了idx,idx是一个基准计算位置，因为如果中间出现了重复元素，那么就要夸过去。
             if(strPositionMap.get(s.substring(i,i+1)) != null && strPositionMap.get(s.substring(i,i+1)) > idx){
                 idx = strPositionMap.get(s.substring(i,i+1));
                 
             }
             
             
             if((i - idx) > answer){
                 answer = i - idx;
             }
             
             //每次字符的出现位置覆盖上次出现的位置
             strPositionMap.put(s.substring(i,i+1),i);
         }
     
         return answer;
     }
}
