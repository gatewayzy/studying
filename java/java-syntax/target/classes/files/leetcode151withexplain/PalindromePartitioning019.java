package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 * 本题的题意就是给出一个字符串，将所有能够拆分成的回文子串返回。例如：
 * For example, given s = "aab",
      Return
	  [
	    ["aa","b"],
	    ["a","a","b"]
	  ]
 *
 * 解题思路：深度优先遍历，每一层都有若干种可能，然后如果是回文，那么就进入深度优先遍历。
 * 
 * 注意点：这种深度优先遍历的思想会在后面的题目中经常的用到，每一层压入一个结果之后，后续还要弹出这个结果。
 *
 */
public class PalindromePartitioning019 {
	
	public  ArrayList<ArrayList<String>> partition(String s) {
		//用于存储结果
    	ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
    	//临时结果  以后经常用到这种结构，基本思想就是深度优先遍历
    	ArrayList<String> temp = new ArrayList<>();
    	generatePalindrome(results, temp, s);
    	return results;
    }
    
    
    public static void generatePalindrome(ArrayList<ArrayList<String>> results,ArrayList<String> temp,String s){
    	//边界条件   别忘了是add new ArrayList()
    	if(s.length() == 0){
    		results.add(new ArrayList<>(temp));
    	}
    	//深度优先遍历  某一层的各种情况考虑
    	for(int i = 1; i <= s.length(); i++){
    		String cs = s.substring(0,i);
    		//如果是回文，那么就进度深度遍历
    		if(isPalindromeOrNot(cs)){
    			temp.add(cs);
    			generatePalindrome(results, temp, s.substring(i));
    			//别忘了remove
    			temp.remove(temp.size()-1);
    		}
    	}
    }
    
    
    //判断一个字符串是不是回文串
    public static boolean isPalindromeOrNot(String s){
    	
    	boolean result = true;
    	int left = 0;
    	int right = s.length()-1;
    	while(left < right){
    		if(!(s.substring(left, left+1).equals(s.substring(right, right+1)))){
    			result = false;
    			return result;
    		}
    		left++;
    		right--;
    	}
    	return result;
    }
}
