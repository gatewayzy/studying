package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 * 本题题意就是判断一个给定的字符串是不是一个回文，这个字符串里面包含非字符的数据
 * 
 *  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

	For example,
	"A man, a plan, a canal: Panama" is a palindrome.
	"race a car" is not a palindrome.
 *
 *  解题思路：先对数组进行预处理，即把所有的字符都抽取出来，然后放到一个arraylist中，然后在判断是否是回文。
 */
public class ValidPalindrome026 {

	public boolean isPalindrome(String s) {
		
		//特殊情况处理  空字符串也是回文
        if(s == null) return false;
        if(s.replaceAll(" ","").equals("")) return true;
        
        //通过一个数组列表来存储每一个结果
        int sLength = s.length();
        ArrayList<String> tempStrings = new ArrayList<String>();
        for(int i = 0; i < sLength; i++){
            int chr = s.charAt(i);
            //assic码值  数字  大写字母  小写字母
	        if((chr >= 48 && chr <= 57) ||(chr >= 65 && chr <= 90) ||(chr >= 97 && chr <= 122)){
	    	  tempStrings.add(String.valueOf(s.charAt(i)));
	        }
        }
        
        //通过数组列表来判断是否是回文，其实就是预处理了
        int tempStringsSize = tempStrings.size();
        int left = 0;
        int right = tempStringsSize-1;
        while(left <= right){
            if(tempStrings.get(left).toLowerCase().equals(tempStrings.get(right).toLowerCase())){
                left++;
                right--;
            }else{
                return false;
            }
        }
        
        return true;
    }
}
