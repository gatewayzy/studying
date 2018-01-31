package _programming.leetcode151withexplain;

/**
 * 本题题意：给出两个字符串，代表两个数字，然后求出其乘积
 * 
 * 解题思路：通过一个数组来记录每一位上积累的数值。模拟乘法计算，然后计算出每一位上面的数字。别忘了进位的计算。别忘了去掉数组前面为0的部分。
 *
 */
public class MultiplyStrings110 {
	
	 //用于记录每一位上面的数值多少
	 public int[] positionValue;
	 
     public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) return null;
        if(num1.equals("0") || num2.equals("0")) return "0";
       
        //交换一下顺序  方便后续的计算
        if(num1.length() < num2.length()){
        	String temp = num1;
        	num1 = num2;
        	num2 = temp;
        }
        
        //计算出最长位数  两个二位数相乘，最多是四位数
        int num1Size = num1.length();
        int num2Size = num2.length();
        int totalSize = num1Size + num2Size + 1;
        positionValue = new int[totalSize];
        
        for(int i = 0; i < num2Size; i++){
            helper(num1,i,num2.substring(num2Size-1-i,num2Size-i));
        }
        
        String answer = getAnswer();  
        return answer;         
     }
     
     //返回结果
     public String getAnswer(){
    	 
    	 String answer = "";
    	 int pValueSize = positionValue.length;
    	 int flag = 0;
    	 //可能位数申请的比较多，把是0的去掉
    	 for(int j = pValueSize-1; j >= 0; j--){
    		 if(positionValue[j] == 0){
    			 pValueSize--;
    			 continue;
    		 }else{
    			 break;
    		 }
    	 }
    	 //遍历每一个位置，然后求出字符串
    	 for(int i = 0; i < pValueSize; i++){
    		 int currentSum = positionValue[i] + flag;
    		 if(currentSum >= 10){
    			 answer = currentSum % 10 + answer;
    			 flag = currentSum / 10;
    		 }else{
    			 answer = currentSum + answer;
    			 flag = 0;
    		 }
    	 }
    	 
    	 //别忘了最后的进位
    	 if(flag != 0){
    		 answer = flag + answer;
    	 }
    	 
    	 return answer;
     }
     
     /**
      * 采用乘法的传统思想   被乘数的每一位分别与乘数相乘   获取到的数值对应位置相加就可以了
      * @param num1
      * @param startPosition 开始计数的位置
      * @param multipa
      */
     public void helper(String num1,int startPosition, String multipa){
        int num1Length = num1.length();
        int flag = 0;
        for(int i = 0; i < num1Length; i++){
            int currentResult = Integer.parseInt(num1.substring(num1Length-i-1,num1Length-i)) * Integer.parseInt(multipa);
            //别忘了进位运算
            int currentInt = currentResult + flag;
            int gewei = currentInt % 10;
            int shiwei = currentInt / 10;
            //求出positionValue
            if(currentInt >= 10){
                flag = shiwei;
                positionValue[startPosition] = positionValue[startPosition] + gewei;
                startPosition++;
            }else{
            	positionValue[startPosition] = positionValue[startPosition] + gewei;
            	startPosition++;
                flag = 0;
            }
        }
        
        //别忘了最后进位的处理
        if(flag != 0){
            positionValue[startPosition] = positionValue[startPosition] + flag;
        }
    }
}
