package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 * 本题题意：给出一个数字字符串，然后根据手机上面的按键，给出所有可以拼凑出来的字符串。
 * 
 * Input:Digit string "23"  Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 解题思路：通过递归调用，边界条件就是一个字符的时候，那么返回其对应的所有字符就可以了。获取本层的所有字符，然后获取下一轮中的所有字符，然后两个两个拼凑出最终的结果
 *
 */
public class LetterCombinationsofaPhoneNumber133 {
	
	
	   public ArrayList<String> letterCombinations(String digits) {
	        int digitSize = digits.length();
	        //如果字符串长度为0  特殊处理
	        if(digitSize == 0){
	            ArrayList<String> answer = new ArrayList<String>();
	            answer.add("");
	            return answer;
	        }
	        
	        return getCombinationLetters(digits,digitSize-1);
	    }
	    
	   	/**
	   	 * 获取结果
	   	 * @param digits 给出的数字字符串
	   	 * @param currentPosition 当前考虑的位置
	   	 * @return
	   	 */
	    public ArrayList<String> getCombinationLetters(String digits,int currentPosition){
	        
	    	//存储结果用
	        ArrayList<String> results = new ArrayList<String>();
	        
	        //存储临时结果
	        ArrayList<String> tempResults = new ArrayList<String>();
	        
	        //获取当前字符
	        String currentDigit = digits.substring(currentPosition,currentPosition+1);
	        //获取字符对应的字符
	        tempResults = getStringsByNum(currentDigit);
	        //如果当前位置是第一个字符，那么答案就是结果集  也属于边界条件了
	        if(currentPosition == 0){
	            results = tempResults;
	            return results;
	        }
	        
	        //获取下一轮的所有结果
	        ArrayList<String> nextResults = getCombinationLetters(digits,currentPosition-1);
	        
	        //拼凑两次的结果   记录到结果集中
	        for(String tempS : tempResults){
	            for(String nextS : nextResults){
	                results.add(nextS+tempS);   
	            }
	        }
	        
	        return results;
	    }
	    
	    //用于返回每一个数字对应的String
	    public ArrayList<String> getStringsByNum(String number){
	        ArrayList<String> results = new ArrayList<String>();
	        
	         if(number.equals("2")){
	            results.add("a");
	            results.add("b");
	            results.add("c");
	        }
	        
	        if(number.equals("3")){
	            results.add("d");
	            results.add("e");
	            results.add("f");
	        }
	        
	        if(number.equals("4")){
	            results.add("g");
	            results.add("h");
	            results.add("i");
	        }
	        
	        if(number.equals("5")){
	            results.add("j");
	            results.add("k");
	            results.add("l");
	        }
	        
	        if(number.equals("6")){
	            results.add("m");
	            results.add("n");
	            results.add("o");
	        }
	        
	        if(number.equals("7")){
	            results.add("p");
	            results.add("q");
	            results.add("r");
	            results.add("s");
	        }
	        
	        if(number.equals("8")){
	            results.add("t");
	            results.add("u");
	            results.add("v");
	        }
	        
	        if(number.equals("9")){
	            
	            results.add("w");
	            results.add("x");
	            results.add("y");
	            results.add("z");
	        }
	     
	        return results;
	    }
	    
	    public static void main(String[] args){
	    	int a = 97 + 0;
	    	System.out.println(String.valueOf((char)(a)));
	    }
}
