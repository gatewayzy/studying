package _programming.leetcode151withexplain;

/**
 *  本题题意：给出一个二维数组  里面每一个格子都是一个字符   给出一个字符串  看能否在这个格子中找到这个字符串
 *  
 *   For example,
	Given board =
	
	[
	  ["ABCE"],
	  ["SFCS"],
	  ["ADEE"]
	]
	word = "ABCCED", -> returns true,
	word = "SEE", -> returns true,
	word = "ABCB", -> returns false.
	
	解题思路：把二维矩阵中的每一个点作为开始节点，遍历二维矩阵，左右上下的递归调用，看能否得到想要的字符串。
	
	注意点：一般二维矩阵中寻找东西往往都这样做；方法的参数也要注意，传递的是什么。另外，对于当前节点，设置为.，以防止后续重复遍历，但是别忘了后来还得设置回去。
	
 *
 */


public class WordSearch073 {
	
	   public static boolean exist(char[][] board, String word) {  
		   //循环遍历每一个元素，作为开始节点，遍历二维数组
		   for(int i=0; i<board.length; i++){  
	            for(int j=0; j<board[0].length; j++){  
	                if(dfs(board, word, 0, i, j)){  
	                    return true;  
	                }  
	            }  
	        }  
	        return false;  
	    }  
	       
	    /**
	     * 深度优先遍历
	     * @param board 二维数组
	     * @param word 目标单词
	     * @param index 当前的位置
	     * @param x 当前节点坐标x
	     * @param y 当前节点坐标y
	     * @return
	     */
	    public static boolean dfs(char[][] board, String word, int index, int x, int y){  
	    	//边界条件  代表已经找到了该单词
	        if(index == word.length()-1 && word.charAt(index)==board[x][y]){  
	            return true;  
	        }  
	        
	        //当前字符不等于要查找的单词
	        if(word.charAt(index) != board[x][y]){  
	            return false;  
	        }  
	        
	        //获取当前字符
	        char tmp = board[x][y];
	        //设置为.  以防重复遍历
	        board[x][y] = '.';  
	        boolean b1 = false, b2 = false, b3 = false, b4 = false;
	        
	        //递归调用  上下左右遍历
	        if(x-1>=0 && board[x-1][y] != '.'){  
	            b1 = dfs(board, word, index+1, x-1, y);  
	        }  
	        if(!b1 && y-1>=0 && board[x][y-1] != '.'){  
	            b2 = dfs(board, word, index+1, x, y-1);  
	        }  
	        if(!b1 && !b2 && x+1<board.length && board[x+1][y] != '.'){  
	            b3 = dfs(board, word, index+1, x+1, y);  
	        }  
	        if(!b1 && !b2 && !b3 && y+1<board[0].length && board[x][y+1] != '.'){  
	            b4 = dfs(board, word, index+1, x, y+1);  
	        }  
	        
	        //恢复原来的设置
	        board[x][y] = tmp;  
	        return b1 || b2 || b3 || b4;  
	    }
	    
	    //another method    
	    public boolean exist2(char[][] board, String word) {
	        boolean answer = false;
	        if(word == null || word.equals("")) return true;
	        int m = board.length;
	        if(m == 0) return false;
	        int n = board[0].length;
	        int wSize = word.length();
	        char[] ws = word.toCharArray();
	        
	        char firstChar = ws[0];
	        for(int i = 0; i < m; i++){
	            for(int j = 0; j < n; j++){
	                if(board[i][j] == firstChar){
	                    if(getResult(board,ws,i,j,m,n,0)){
	                        return true;
	                    }
	                }
	            }
	        }
	        
	        return answer;
	    }
	    
	    public boolean getResult(char[][] board, char[] ws, int curX, int curY, int m, int n, int curNum){
	        if(curX < 0 || curX >= m) return false;
	        if(curY < 0 || curY >= n) return false;
	        
	        if(board[curX][curY] == '.'){
	            return false;
	        }
	        
	        
	        if(ws[curNum] != board[curX][curY]) return false;
	        if(curNum == ws.length-1) return true;

	        char temp = board[curX][curY];
	        board[curX][curY] = '.';
	        boolean result = getResult(board,ws,curX+1,curY,m,n,curNum+1);
	        if(result == true) return true;
	        boolean result1 = getResult(board,ws,curX-1,curY,m,n,curNum+1);
	        if(result1 == true) return true;
	        boolean result2 = getResult(board,ws,curX,curY+1,m,n,curNum+1);
	        if(result2 == true) return true;
	        boolean result3 = getResult(board,ws,curX,curY-1,m,n,curNum+1);
	        if(result3 == true) return true;
 
	        board[curX][curY] = temp;
	        return result;
	    }
	    
	    public static void main(String[] args){
	    	WordSearch073 obj = new WordSearch073();
	    	
	    	char[][] board = {{'a','b'},{'c','d'}};
	    	String target = "cdba";
	    	
	    	obj.exist2(board, target);
	    }
	    
}
