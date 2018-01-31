package _programming.leetcode151withexplain;

/**
 * 本题题意：给出字符串，将其转化为整数类型
 * 
 * 判断规则：前后可以有空格，也可能有正负号出现；然后从第一个数字开始遍历到非数字的出现，返回结果就可以。否则返回0
 *
 * 解题思路：从前往后遍历，如果出现了数字之后那么就不能再有其他字符出现了；如果出现了正负号之后就不能在出现其他字符了。
 * 
 * 想法：很多题目中都带上这么一个标记符号，来标示某些字符是否出现过。
 */
public class StringtoIntegeratoi144_ThinkAgain {
	
     public static void main(String[] args){
    	 StringtoIntegeratoi144_ThinkAgain object = new StringtoIntegeratoi144_ThinkAgain();
    	 System.out.println(object.atoi("    -2 3"));
     }
	
	
	 public int atoi(String str) {
		 //特殊情况处理
         if(null==str||str.length()==0)
             return 0;
         
         //转化为字符数组
         char[] arr=str.toCharArray();
         //记录结果
         long res=0;
         //是否为负数
         boolean isNegative=false;
         //是否存在了一些特殊的情况
         boolean existed=false;
         
         //从前往后遍历
         for(int i=0;i<arr.length;i++)
         {
         	if(isDigit(arr[i]))//如果出现的是数字
         	{
         		res=res*10+(arr[i]-48);
         		if(!existed) existed=true; //出现数字之后就标示出existed为true
         	}
         	else if(arr[i]=='-'&&!existed)//出现了负号   前面还没出现特殊情况
         	{
         		isNegative=true;
         		if(!existed) existed=true;
         	}
         	else if(arr[i]=='+'&&!existed)//positive
         	{
         	    if(!existed) existed=true;
         	}
         	else if(arr[i]==' '&&!existed)//blank
         		;
         	else break;	 //illlegal       	
         }
         
         //如果是负数  要判断是否小于整数最小值
         if(isNegative)
         {
         	res=0l-res;
         	return res<Integer.MIN_VALUE?Integer.MIN_VALUE:(int)res; //consider integer scope
         }
         else {
     		return res>Integer.MAX_VALUE?Integer.MAX_VALUE:(int)res;
     	}
	}
	 
	 //判断一个字符是否为数字
	 private boolean isDigit(char c)
	 {
	     return c >= 48 && c <= 57;
	 }
	 
	 
	 public int atoi1(String str) {
		 long ans = 0;
		 boolean isPositive = true;
		 boolean existOrNot = false;
		 char[] array = str.toCharArray();
		 int aLength = array.length;
		 for(int i = 0; i < aLength; i++){
			 
			 char cur = array[i];
			 if(isDigit1(cur)){
				 ans  = ans * 10 + (cur - 48);
				 if(!existOrNot) existOrNot = true;
			 }else if(cur == '+' && !existOrNot){
				 
				 if(!existOrNot) existOrNot = true;			 
			 }else if(cur == '-' && !existOrNot){
				 isPositive = false;
				 if(!existOrNot) existOrNot = true;
			 }else if(cur == ' ' && !existOrNot){
				 
			 }else{
				 break;
			 }
			 
		 }
		 
		 if(!isPositive){
			 ans = 0 - ans;
			 if(ans <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
			 else return (int)ans;
		 }else{
			 if(ans >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
			 else return (int)ans;
		 }
		 
		 
	 }
	 
	 private boolean isDigit1(char c){
		 if(c >= 48 && c <= 57){
			 return true;
		 }else{
			 return false;
		 }
	 }
	 
}
