package _programming.leetcode151withexplain;

import java.util.ArrayList;

/**
 * 解题思路：给出数字n  给出所有由n个（和n个）构成的所有的括号对。
 * 
 * 	For example, given n = 3, a solution set is:
	"((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 *	本题思路：记录住左括号的数目和右括号的数目，如果左括号到了n个，那么就开始加入右括号。如果左括号数目大于右括号数目的时候，可以加入右括号。
 */
public class GenerateParentheses130 {
	
	public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> results = new ArrayList<String>();
        //递归调用  results结果集  temp临时结果  以及n值  现有的(数目和）数目
        getResult(results,"",0,0,n);
        return results;
    }
    
	/**
	 * 递归调用方法
	 * @param results  结果集
	 * @param temp  临时结果
	 * @param lpSize 左括号的数目
	 * @param rpSize 右括号的数目
	 * @param n 括号多少
	 */
    public void getResult(ArrayList<String> results,String temp,int lpSize, int rpSize,int n){
        //when has n left parenthesis
    	//当左括号的数目等于n的时候
        if(lpSize == n){
        	//那么在temp后面加上还可以加入的）数目
            for(int i = 0; i < n - rpSize;i++){
                temp = temp+")";
            }
            //加入结果集
            results.add(temp);
            return;
        }
        
        //加入左括号
        getResult(results,temp+"(",lpSize+1,rpSize,n);
        //当左括号的数目大于右括号的数目，那么就开始加入右括号
        if(lpSize > rpSize){
            getResult(results,temp+")",lpSize,rpSize+1,n);
        }
        
    }
}
