package _programming.leetcode151withexplain;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 本题题意：给一个二维矩阵，里面只包含0和*,把所有被*包围的0转化为*.包围的意思是四面都有*
 * 
 * 本题解题思路：
 * 反向思维，如果一个0不被*包围，那么就可能在边界上，那么从边界上面的所有0开始往里面遍历，那么所能达到的地方便可以改变为临时Z字符。最后修改一下就可以了。
 * 本为通过queue将所有的节点压入到队列中，然后类似于宽度优先遍历的方式，不断的往两边扩大遍历范围。
 * 
 * 宽度优先的方式就是通过压入队列，然后依次处理每一个节点，这样就好像一圈一圈的往外拓展一样。
 * 
 * 也可以通过深度优先解决问题，那就是采用DFS的策略。
 * 
 *
 */
public class SurroundedRegions021 {

	    private int m, n;  
	    private char[][] board;  
	    private Queue<Integer> queue = new LinkedList<Integer>();  
	  
	    public void add(int x, int y) {
	    	//如果点符合遍历条件：不出界而且为0，那么就加入到队列中
	        if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {  
	            board[x][y] = 'Z';
	            //压入队列
	            queue.offer(x * n + y);  
	        }  
	    }  
	      
	    public void traversal(int x, int y) {  
	        add(x, y);  
	        while (!queue.isEmpty()) {
	        	//弹出队列，恢复得到原来的x和y坐标
	            int p = queue.poll();  
	            int px = p / n;  
	            int py = p % n;  
	            
	            //递归设置 其实也是循环遍历
	            add(px - 1, py);  
	            add(px + 1, py);  
	            add(px, py - 1);  
	            add(px, py + 1);  
	        }  
	    }  
	  
	    public void solve(char[][] board) {  
	    	//特殊条件处理
	        if (board == null || board.length == 0 || board[0].length == 0) {  
	            return;  
	        }  
	        this.board = board;
	        
	        //获取矩阵的长和款
	        m = board.length;  
	        n = board[0].length;
	        
	        
	        //一次处理第一行数据和最后一行数据（即处理边界数据）
	        for (int i = 0; i < n; i++) {  
	            traversal(0, i);  
	            traversal(m - 1, i);              
	        }
	        
	        //处理第一列和最后一列 （处理左右两个边界）
	        for (int i = 0; i < m; i++) {  
	            traversal(i, 0);  
	            traversal(i, n - 1);  
	        }
	        
	        //在中间过程中将不被包围的声明为Z，然后逐次替换就可以了
	        for (int i = 0; i < m; i++) {  
	            for (int j = 0; j < n; j++) {  
	                board[i][j] = board[i][j] == 'Z' ? 'O' : 'X';  
	            }  
	        }  
	    }
	    
	    
	    public void solve2(char[][] board) {
	    	int m = board.length;
	        if(m == 0) return;
	        int n = board[0].length;
	        int[][] visited = new int[m][n];
	        for(int i = 0; i < n; i++){
	            if(visited[0][i] == 0 && board[0][i] == 'O'){
	                changeNum(board,visited,0,i,m,n);
	            }
	            
	            if(visited[m-1][i] == 0 && board[m-1][i] == 'O'){
	                changeNum(board,visited,m-1,i,m,n);
	            }
	        }
	        
	        for(int i = 1; i < m-1; i++){
	            if(visited[i][0] == 0 && board[i][0] == 'O'){
	                changeNum(board,visited,i,0,m,n);
	            }
	            
	            if(visited[i][n-1] == 0 && board[i][n-1] == 'O'){
	                changeNum(board,visited,i,n-1,m,n);
	            }
	        }
	        
	        for(int i = 0; i < m; i++){
	            for(int j = 0; j < n; j++){
	                if(board[i][j] == 'c'){
	                    board[i][j] = 'O';
	                }else{
	                    board[i][j] = 'X';
	                }
	            }
	        }
	        
	    }
	    
	    public void changeNum(char[][] board, int[][] visited, int curX, int curY, int m, int n){
	        if(curX < 0 || curX >= m) return;
	        if(curY < 0 || curY >= n) return;
	        if(board[curX][curY] != 'O') return;
	        if(visited[curX][curY] == 1) return;
	        
	        board[curX][curY] = 'c';
	        visited[curX][curY] = 1;
	        
	        changeNum(board,visited,curX+1,curY,m,n);
	        changeNum(board,visited,curX-1,curY,m,n);
	        changeNum(board,visited,curX,curY+1,m,n);
	        changeNum(board,visited,curX,curY-1,m,n);
	    }
	    
	    
	    public static void main(String[] args){
	    	char[][] param = {{'X','X','X'},{'X','o','X'},{'X','X','X'}};
	    	SurroundedRegions021 obj = new SurroundedRegions021();
	    	obj.solve2(param);
	    }
	    
	    
}
