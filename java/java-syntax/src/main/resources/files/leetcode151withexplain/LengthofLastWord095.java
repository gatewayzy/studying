package _programming.leetcode151withexplain;

/**
 *  本题题意：给出一个字符串，返回该字符串最后一个单词的长度。
 *  
 *  For example, 
	Given s = "Hello World",
	return 5.
 *
 *	解题思路：很简单，直接从后面开始遍历，先找到第一个不是空格的位置，然后从该位置继续往前找，直到遇到下一个空格，就可以求出长度
 */
public class LengthofLastWord095 {
	
 	public int lengthOfLastWord(String s) {
        int answer = 0;
        int sLength = s.length();
        
        //从后面往前遍历，直到遇到第一个字符
        int firstPosition = sLength;
        for(int i = 0; i < sLength; i++){
            String currentS = s.substring(sLength-1-i,sLength-i);
            if(currentS.equals(" ")){
                firstPosition--;
            }else{
                break;
            }
        }
        
        //从后面的第一个字符开始遍历，直到出现空格，那么就能求出answer
        for(int j = 0; j < firstPosition; j++){
            String currentS = s.substring(firstPosition-1-j,firstPosition-j);
            if(currentS.equals(" ")){
                break;
            }else{
                answer++;
            }
        }
        
        return answer;
    }
}
