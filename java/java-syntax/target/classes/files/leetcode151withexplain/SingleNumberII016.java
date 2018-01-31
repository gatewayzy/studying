package _programming.leetcode151withexplain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *  本题题意就是给定一个数组，数组中数一般都出现三次，只有一个数出现了不是三次。
 *  
 *   可以通过一个map来存储数以及出现的次数。
 *   
 *   对于map的操作要正确
 *
 */
public class SingleNumberII016 {

	public int singleNumber(int[] A) {
        Map<Integer,Integer> numberNums = new HashMap<Integer,Integer>();
        for(int i = 0; i < A.length; i++){
            if(numberNums.get(A[i]) != null){
                int aiNums = numberNums.get(A[i]);
                numberNums.remove(A[i]);
                numberNums.put(A[i],aiNums+1);
            }else{
                numberNums.put(A[i],1);
            }
        }
        
        Iterator ite = numberNums.keySet().iterator();
        while(ite.hasNext()){
            int currentKey = (int)ite.next();
            if(numberNums.get(currentKey) != 3){
                return currentKey;
            }
        }
        
        return 0;
    }
}
