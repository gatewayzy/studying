package _programming.leetcode151withexplain;

/**
 * 本题题意：给出两个字符串S和T，在S中找出包含T中所有字符的最短子串
 * For example,
	S = "ADOBECODEBANC"
	T = "ABC"
	Minimum window is "BANC".
	
	解题思路：通过两个数组，一个用于记录需要找到的字符有多少；一个用于存储已经找到的字符有多少；
	用一个变量存储当前已经找到的可用字符数目；当已经达到了可用字符的时候，便进入循环，把多余的字符去除，直到正好可以达到所需的字符；
	然后求出最短窗口的开始位置和结束位置。然后循环遍历。
	
	就是当每一个字符都出现的时候，那么我就认为可以找到这么一个范围了，但是字符有重复的，那么越往后出现的时候，可能窗口就越小，所以要不断的缩小窗口。
 *
 */
public class MinimumWindowSubstring076 {
	
	public static void main(String[] args){
		String S = "aabcedfsgabced";
		String T = "abc";
		MinimumWindowSubstring076 object = new MinimumWindowSubstring076();
		object.minWindow(S, T);
	}
	
	public String minWindow(String S, String T) {
		//特殊情况处理
		int sLen=S.length();  
        int tLen=T.length();  
        if(tLen==0 || sLen < tLen) return "";  
          
        //两个数组用于记录  需要找到的字符与已经找到的字符
        //assic之所以是0-127是因为，1byte是8位，可以表示256个数，但是没有那么多字符，只用到了七位，第一位为0.所以是128个，从0-128
        int[] needFind = new int[256]; 
        int[] hasFind = new int[256];  
          
        //初始化需要的字符数组
        for(int i = 0; i < tLen; i++)  
        {  
            needFind[T.charAt(i)]++;  
        }  
          
        //最小的窗口长度
        int minWindowLength=Integer.MAX_VALUE;
        //最小窗口的开始位置和结束位置
        int minBegin = 0;  
        int minEnd = sLen - 1;
        //开始位置和结束位置
        int begin=0;  
        int end=0;
        
        
        for(int count=0;end<sLen;end++){  
            //如果字符不存在与T中，那么就continue
            if(needFind[S.charAt(end)]== 0) continue;  
              
            //如果包含在T中，那么找到一个就在已找到的数组位置++
            hasFind[S.charAt(end)]++;
            
            //update the total number of characters found(aaa only counts 2 for aa in T)
            //只要是所需的字符未得到满足  那么count就++
            if(hasFind[S.charAt(end)] <= needFind[S.charAt(end)])  
                count++;  
                  
            //a window exists from begin to end
            //即已经找到了所需的所有字符
            if(count == tLen){  
                //move begin pointer to find the minimum window
            	//end记录的是当前已经访问到的位置
                while(begin < end){
                	//如果遇到的字符不需要，那么就跨过去
                    if(needFind[S.charAt(begin)]==0){  
                        begin++;  
                        continue;  
                    }  
                    //已经找到的大于所需要的
                    if(hasFind[S.charAt(begin)] > needFind[S.charAt(begin)]){  
                        //已经找到的就--
                    	hasFind[S.charAt(begin)]--;
                    	//往前移动
                        begin++;  
                        continue;  
                    }  
                    else  
                        break;  
                }  
                  
                int tmpWindowLength=end-begin+1;  
                  
                if(tmpWindowLength < minWindowLength)  
                {  
                    minBegin=begin;  
                    minEnd=end;  
                    minWindowLength=tmpWindowLength;  
                }  
            }  
        }  
          
        if(minWindowLength == Integer.MAX_VALUE)  
            return "";  
        
        return S.substring(minBegin,minBegin+minWindowLength);  
		      
	}
}
