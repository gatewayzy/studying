package _programming.leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;


/**
 * 正常的运算符a+b叫中缀表达式，也有前缀表达式和后缀表达式。为了几年波兰数学家，将后缀表达式成为逆波兰表达式；前缀表达式称为波兰表达式。
 * 后缀表达式的优点是显而易见的，编译器在处理时候按照从左至右的顺序读取逆波兰表达式，遇到运算对象直接压入堆栈，遇到运算符就从堆栈提取后进的两个对象进行计算，这个过程正好符合了计算机计算的原理。
 *Reverse Polish Notation   
 *["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5))
 * 
 * 用一个数组列表模拟栈，遇到数字就压入栈，遇到运算符就从栈中取出数字进行计算，然后将中间结果存入栈中。
 * 
 * 时间复杂度：O（n）
 * 
 * 注意点：及时更新栈的大小
 */
public class EvaluateReversePolishNotation002 {
	
	public int evalRPN(String[] tokens) {
		
		//用numbers模拟栈  栈用于存储将要被计算的数字
        List<Integer> numbers = new ArrayList<Integer>();
        int firstNum;
        int secondNum;
        int numberSize;
        
        //依次获取每一个字符，然后判断类型
        for(String currentToken : tokens){
        	
        	//每一次都要记得更新numberSize
        	numberSize = numbers.size();
        	if(currentToken.equals("+")){
        		firstNum = numbers.get(numberSize-2);
        		secondNum = numbers.get(numberSize-1);
        		numbers.remove(numberSize-1);
        		numberSize = numbers.size();
        		numbers.remove(numberSize-1);
        		//计算出中间结果，再压入栈中
        		int middleResult = firstNum + secondNum;
        		numbers.add(middleResult);
        		
        	}else if(currentToken.equals("-")){
        		firstNum = numbers.get(numberSize-2);
        		secondNum = numbers.get(numberSize-1);
        		numbers.remove(numberSize-1);
        		numberSize = numbers.size();
        		numbers.remove(numberSize-1);
        		int middleResult = firstNum - secondNum;
        		numbers.add(middleResult);
        		
        	}else if(currentToken.equals("*")){
        		firstNum = numbers.get(numberSize-2);
        		secondNum = numbers.get(numberSize-1);
        		numbers.remove(numberSize-1);
        		numberSize = numbers.size();
        		numbers.remove(numberSize-1);
        		int middleResult = firstNum * secondNum;
        		numbers.add(middleResult);
        	}else if(currentToken.equals("/")){
        		firstNum = numbers.get(numberSize-2);
        		secondNum = numbers.get(numberSize-1);
        		numbers.remove(numberSize-1);
        		numberSize = numbers.size();
        		numbers.remove(numberSize-1);
        		int middleResult = firstNum / secondNum;
        		numbers.add(middleResult);
        	}else{
        		numbers.add(Integer.parseInt(currentToken));
        	}
        	
        	
        }
        return numbers.get(0);
    }
}
