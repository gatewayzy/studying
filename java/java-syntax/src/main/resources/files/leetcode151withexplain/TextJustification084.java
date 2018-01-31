package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;

/**
 * 本题题意：给出一个字符串，然后给出一个长度，希望能够把字符串分解成为每一行长度都是给定长度的几个字符串。
 * 
 *  For example,
	words: ["This", "is", "an", "example", "of", "text", "justification."]
	L: 16.
	
	Return the formatted lines as:
	[
	   "This    is    an",
	   "example  of text",
	   "justification.  "
	]
	
	本题思路：通过一个数据结构记录住每一行的开始元素，结束元素以及空格的数目。然后遍历每一个元素，打印出字符串。但是计算空格的时候要特别的注意。
	
	
 *
 */
public class TextJustification084 {
	
	//声明了一个数据结构   该数据结构用于存储分解出来的每一行  从哪个字符串开始到哪一个结束  这一行能有多少空格
	class Item{
        int startPosition;
        int endPosition;
        int blankNum;
        Item(int s, int e, int b){
            startPosition = s;
            endPosition  = e;
            blankNum = b;
        }
    }
    
    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        int wordsSize = words.length;
        if(wordsSize == 0) return result;
        
        //用于记录分解结果
        ArrayList<Item> items = new ArrayList<Item>();
        for(int i = 0; i < wordsSize; i++){
            int tempL = L;
            int startPosition = i;
            int endPosition = i;
            while(tempL > 0 && i < wordsSize){
            	//获取字符并且获取其长度
                String currentWord = words[i];
                int cwLength = currentWord.length();
                //如果一个字符的长度大于L，那么题目有错误
                if(cwLength > L){
                    return null;
                //如果剩余的长度大于该字符的长度，那么说明该字符串可以加入到结果中
                }else if(tempL >= cwLength){
                    endPosition++;
                    tempL -= cwLength;
                    //blank 剪刀一个空格
                    tempL--;
                }else{
                    break;
                }
                i++;
            }
            if(i > 0){i--;} //别忘了i往后退一步
        	endPosition--;
        	//增加一个新的item
            Item newitem = new Item(startPosition,endPosition,tempL+(endPosition-startPosition)+1);
            items.add(newitem);
        }
        
        int itemsSize = items.size();
        //遍历每一个item，构建结果
        for(int j = 0; j < itemsSize; j++){
            String jthResult = "";
            Item currentItem = items.get(j);
            int startP = currentItem.startPosition;
            int endP = currentItem.endPosition;
            int blankSize = currentItem.blankNum;
            //如果正好是最后一个元素  那么除了该元素  后面都是空格
            if(j == (itemsSize - 1)){
            	for(int k = startP; k <= endP; k++){
	            	int blank = 0;
	                jthResult += words[k];
	                for(int p = 0; k == endP && p < blankSize; p++){
	                    jthResult += " ";
	                }
	                if(k == endP) continue;
	                jthResult += " ";
	                blankSize--;
	            }
            }else{
            	//对于其他的情况  要学会计算空格的多少
	            for(int k = startP; k <= endP; k++){
	            	int blank = 0;
	            	if(endP-k != 0){
	            		blank = (int)Math.ceil((double)blankSize/(endP-k));
	            	}
	            	if(startP == endP){
	            		blank = blankSize;
	            	}
	                jthResult += words[k];
	                for(int p = 0; p < blank; p++){
	                    jthResult += " ";
	                }
	                blankSize -= blank;
	            }
            }
            result.add(jthResult);
        }
        
        return result;
    }  
}
