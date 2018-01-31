package _programming.leetcode151withexplain;

import java.util.ArrayList;


/**
 * 本题题意：通过遍历每一个位置的可填写数字，然后通过深度优先遍历来获取最终的结果。
 * 
 * 本题思路：边界条件要注意，如果已经到了边界，那么就返回true；如果列值超越范围，那么行值加1,列值设置为0
 *
 *
 */
public class SudokuSolver106 {
	
	public void solveSudoku(char[][] board) {
        int rows = board.length;
        if(rows == 0) return;
        int columns = board[0].length;
        solveSudokuHelper(board,0,0,rows,columns);
    }
    
	/**
	 * 解决数独
	 * @param board 数独数据
	 * @param currentRow 当前行
	 * @param currentColumn 当前列
	 * @param rows 总共的行数
	 * @param columns 总共的列数
	 * @return
	 */
    public boolean solveSudokuHelper(char[][] board, int currentRow, int currentColumn, int rows, int columns){
        //如果到了组后的位置
    	if(currentRow == (rows-1) && currentColumn == (columns-1)){
            return true;
        }
        
    	//如果列超界了  那么新行开始   列值设置为0
        if(currentColumn >= columns){
            currentRow++;
            currentColumn = 0;
        }
        
        //如果当前不是.号，说明现在有数字，那么就可以直接跨过
        if(board[currentRow][currentColumn] != '.'){
            solveSudokuHelper(board,currentRow,currentColumn+1,rows,columns);
        }else{
        	
        	//先获取某一空格可以填写的所有可能
	        ArrayList<Integer> availableNum = getAvailableValues(board,currentRow,currentColumn,rows,columns);
	        int avaSize = availableNum.size();
	        //如果可以填写的数字为0 那么返回false
	        if(avaSize == 0) return false;
	        //遍历每一个数字
	        for(int i = 0; i < avaSize; i++){
	        	//当前的设置为某数字
	            board[currentRow][currentColumn] = (char)(availableNum.get(i)+48);
	            //继续下一个处理，如果可以，那么就返回true
	            if(solveSudokuHelper(board,currentRow,currentColumn+1,rows,columns)) return true;
	            //将当前的设置为.
	            board[currentRow][currentColumn] = '.';
	        }
        }
        
        return false;
    }
    
    
    /**
     * 给出位置i j,求出所有可以填写的数字
     * @param board
     * @param i
     * @param j
     * @param rows
     * @param columns
     * @return
     */
    public ArrayList<Integer> getAvailableValues(char[][] board,int i, int j,int rows,int columns){
        //用一个数组记录每一个数字现在出现的次数
    	int[] numbers = new int[9];
        
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        //get row availale
        for(int column = 0; column < columns; column++){
            if(column == j) continue;
            //如果有数字  那么就在对应位置++
            if(board[i][column] != '.'){
                numbers[board[i][column]-49]++;
            }
        }
        
        //get column available
        for(int row = 0; row < rows; row++){
            if(row ==  i) continue;
            if(board[row][j] != '.'){
                numbers[board[row][j]-49]++;
            }
        }
        
        //get area available
        int startRow = i / 3;
        int startColumn = j / 3;
        //对于某一个位置，如何求出气开始的范围区域
        for(int r = startRow * 3; r < (startRow * 3 + 3); r++){
            for(int c = startColumn * 3; c < (startColumn * 3 + 3); c++){
                if(r == i && c == j) continue;
                if(board[r][c] != '.'){
                    numbers[board[r][c]-49]++;
                }
            }
        }
        
        //把没有出现的数字加入结果中
        for(int k = 0; k < 9; k++){
            if(numbers[k] == 0){
                answer.add(k+1);
            }
        }
        
        return answer;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    //another method
    
    public void solveSudoku2(char[][] board) {
        solveSudokuHelper(board);
    }
    
    public boolean solveSudokuHelper(char[][] board){
        int m = board.length;
        if(m == 0) return false;;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '.'){
                    for(int k = 1; k <= 9; k++){
                        board[i][j] = (char) (k + '0');
                        if(isValid(board,i,j) && solveSudokuHelper(board)){
                            return true;
                        }   
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }
    

    public boolean isValid(char[][] board,int i, int j){
        for(int p = 0; p < 9; p++){
            if(p != j && board[i][p] == board[i][j]){
                return false;
            }
        }
        
        for(int q = 0; q < 9; q++){
            if(q != i && board[q][j] == board[i][j]){
                return false;
            }
        }
        
        int x = i/3;
        int y = j/3;
        
        for(int r = 0; r < 3; r++){
            for(int w = 0; w < 3; w++){
                if((x + r) != i && (y + w) != j && board[x + r][y + w] == board[i][j]){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
    
    
    
    
    
    
    
}
