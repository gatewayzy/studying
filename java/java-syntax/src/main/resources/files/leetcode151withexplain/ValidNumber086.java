package _programming.leetcode151withexplain;

/**
 *  本题题意：给出一个字符串  判断其是否为数字 
 *  Some examples:
	"0" => true
	" 0.1 " => true
	"abc" => false
	"1 a" => false
	"2e10" => true
 *	
 *	 本题思路：给出几个布尔变量，用于判断是否已经出现了某种情况。
 *	1、判断e是否出现 2、判断小数点是否出现  3、判断e的左边部分和右边部分  4、空格是否出现
 *
 *	巧妙：就是通过几个布尔变量一起判断是否某些情况出现与否
 */
public class ValidNumber086 {
	
	public boolean isNumber(String s) {
        if(s == null)  return false;  
              
        s = s.trim();
        //是否出现e 小数点  空格   
        boolean eAppear = false;  
        boolean dotAppear = false;
        //e之前为firstPart,之后为secondPart
        boolean firstPart = false;  
        boolean secondPart = false;  
        boolean spaceAppear = false;
        //字符串的长度
        int sLength = s.length();
        for(int i = 0; i < sLength; i++){
        	
        	//如果第一个是正号或者负号
        	if (i==0 && (s.charAt(i) == '+' || s.charAt(i) == '-'))  
                continue; 
        	
        	//如果出现了.号
            if (s.charAt(i) == '.'){
            	//如果。号之前已经出现过.  e  空格  返回false
                if (dotAppear || eAppear || spaceAppear)  
                    return false;  
                else  
                    dotAppear = true;  
            }
            //如果出现了e
            else if (s.charAt(i) == 'e' || s.charAt(i) == 'E')  
            {  
            	//如果之前就出现了e 前面没有内容  出现了空格
                if (eAppear || !firstPart || spaceAppear)  
                    return false;  
                else  
                    eAppear = true;  
            }
            //如果出现了数字  如果前面出现了数字
            else if (s.charAt(i) >= 48 && s.charAt(i) <= 57)  
            {  
            	//如果前面有空格  那么就返回false
                if (spaceAppear)  
                    return false;  
                //如果还没出现e      
                if (!eAppear)  
                    firstPart = true;
                //如果出现了e
                else  
                    secondPart = true;  
            }  
            else if (s.charAt(i) == '+' || s.charAt(i) == '-')   // behind of e/E  
            {  
                if (spaceAppear)  
                    return false;  
                //e还未出现  或者前面的字符不是e和E      
                if (!eAppear || !(s.charAt(i-1) == 'e' || s.charAt(i-1) == 'E'))  
                    return false;  
            }  
            else if (s.charAt(i) == 32)  
                spaceAppear = true;  
            else  
                return false;               
        }  
          
        if (!firstPart) {  
            return false;  
        }  else if (eAppear && !secondPart) {  
            return false;  
        }   
        return true;    
	}
}
