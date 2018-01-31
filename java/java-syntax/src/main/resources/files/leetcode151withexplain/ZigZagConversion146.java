package _programming.leetcode151withexplain;

/**
 * 本题题意：给出一个字符串，该字符串会通过Z字形排列，然后给出Z字形排列的顺序读取结果。
 * 
 *  P   A   H   N
	A P L S I I G
	Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"
    
          解题思路：一行一行的读取，如果是第一行或者最后一行，那么元素之间的差距就是一个固定差；如果是中间行，那么就要知道现在是哪一列，奇数列数值如何计算，偶数列如何计算都是有固定规律的。
 * 
 *
 */
public class ZigZagConversion146 {
	
	public String convert(String s, int nRows) {
		//特殊情况处理
		if (nRows <= 1 || s.length() == 0)  
	           return s;  
	  
        String res = "";  
        int len = s.length();
        //一行一行的读取给出的字符串  注意i的条件是小于长度，小于行数
        for (int i = 0; i < len && i < nRows; ++i)  
        {  
        	//一行一行的读取     关键在于如何计算出下一个位置的下标
            int indx = i;  
            res += s.substring(indx,indx+1);  
  
            for (int k = 1; indx < len; ++k)  
            {  
                //deal with the first and last row
            	//如果当前处理的是第一行或者最后一行  那么元素之间相差的距离就是 2 * nRows - 2
                if (i == 0 || i == nRows - 1)  
                {  
                    indx += 2 * nRows - 2;  
                }  
                //middle rows
                //如果是中间行   那么就要看是位于哪一列上面
                else  
                {  
                    if ((k & 1) > 0) 
                        indx += 2 * (nRows - 1 - i);  
                    else indx += 2 * i;  
                }  
  
                //如果该元素还没越界，那么就增加到结果中
                //judge validate
                if (indx < len)  
                {  
                    res += s.substring(indx,indx+1);  
                }     
            }  
        }  
        return res;  
    }
}
