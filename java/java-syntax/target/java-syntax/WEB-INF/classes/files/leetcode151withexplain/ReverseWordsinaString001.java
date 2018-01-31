package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;

/**
 * 题意：将一句话中的字符串进行反转
 * Given s = "the sky is blue",
   return "blue is sky the".
 * 
 * 本题的解题思路就是通过获取字符串上所有的变化位置，然后两两之间夹着的便是字符串。
 *
 * 时间复杂度 O(n)
 * 空间复杂度 O(n)
 * 
 * 注意点：刚开始在s后面加上空格是为了符合后面的运算方法；字符串的相关处理函数不会改变原有的字符串
 */
public class ReverseWordsinaString001 {

	
	public String reverseWords(String s) {
        //在字符串后面加上空格就是为了适应后面的算法
		s += "  ";
   	 	int sLength = s.length();
        
        List<Integer> resultPositions = new ArrayList<Integer>();
        
        //判断是否字符串为只有空格的字符串
        if(s.replaceAll(" ","").equals("")){
            return "";
        }
        
        //找到第一个为非空的字符串   这里也可以使用string.trim()来直接去掉两端的空格
        int beginPosition = 0;
        for(int i = 0; i < sLength; i++){
            String currentS = s.substring(i,i+1);
            if(currentS.equals(" ")){
                beginPosition++;
            }else{
                break;
            }
        }
        
        //将位置信息加入到结果中
        resultPositions.add(beginPosition);
        
        //循环遍历字符串中的每一个字符，然后找到变化的位置 
        for(int j = beginPosition; j < sLength-1;j++){
            String currentS = s.substring(j,j+1);
            String nextS = s.substring(j+1,j+2);
            if(nextS.equals(" ") && !currentS.equals(" ")){
                resultPositions.add(j+1);
            }
            
            if(!nextS.equals(" ") && currentS.equals(" ")){
                resultPositions.add(j+1);
            }
        }
        
        String results = "";
        //遍历所有坐标，两两数据之间便是所夹着的字符串
        for(int k = resultPositions.size(); k > 1; k = k-2){
            if(k == 2){
                results += s.substring(resultPositions.get(k-2),resultPositions.get(k-1));
            }else{
                results += s.substring(resultPositions.get(k-2),resultPositions.get(k-1))+" ";
            }
        }
          
        return results;
   }
	
	
}
