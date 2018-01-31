package _programming.leetcode151withexplain;

import java.util.HashMap;

/**
 * 最长的连续序列
 * 给出一个尚未排序的数组，然后求里面最长的连续数字长度是度多少。
 * Given [100, 4, 200, 1, 3, 2],
   The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4. 
 *
 * 本题要求的复杂度是O（n），通过一个map来记录数据是否已经被计算过，对于每一个数，先求不断++的数据是否在map中；然后就是数据--的数据是否在map中。
 */
public class LongestConsecutiveSequence023 {

	public int longestConsecutive(int[] num) {
        int numLength = num.length;
        //通过map来标志数据是否被访问过
        HashMap<Integer,Integer> values = new HashMap<>();
        for(int i = 0; i < numLength; i++){
            values.put(num[i],1);
        }
        
        //result记录结果  tempLength记录临时结果
        int result = 0;
        int tempLength = 1;
        for(int j = 0; j < numLength; j++){
            tempLength = 1;
            //开始找数据右边的数据  如果尚未访问，那么就移除这个数据，数目多少++
            int tempNum1 = num[j]+1;
            while(values.containsKey(tempNum1)){
                values.remove(tempNum1);
                tempLength++;
                tempNum1++;
            }
            
            //开始找数据左边的数据
            int tempNum2 = num[j]-1;
            while(values.containsKey(tempNum2)){
                values.remove(tempNum2);
                tempLength++;
                tempNum2--;
            }
            
            //用临时结果替换结果
            if(result < tempLength){
                result = tempLength;
            }
            
        }
        
        return result;
    }
}
