public class Solution {
    private Queue<Integer> queue = new LinkedList<>();
    
    public void solve(char[][] board) {
        if (board.length < 3 || board[0].length <3) return;
        
        int m = board.length, n = board[0].length;
        
        for (int i = 0; i < m; i++){
            if(board[i][0] == 'O') dfs(board, i, 0);
            if(board[i][n-1] == 'O') dfs(board, i, n-1);
        }
        for (int j = 0; j < n; j++){
            if(board[0][j] == 'O') dfs(board, 0, j);
            if(board[m-1][j] == 'O') dfs(board, m-1, j);
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j< n; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
    
    public void dfs(char[][] board, int i, int j){
        int n = board[0].length;
        fill(board, i, j);
        while ( !queue.isEmpty()){
            int cur = queue.poll();
            int x = cur/n;
            int y = cur%n;
            fill(board, x-1, y);
            fill(board, x+1, y);
            fill(board, x, y-1);
            fill(board, x, y+1);
        }
    }
    
    public void fill(char[][] board, int i, int j){
        int m = board.length, n = board[0].length;
        if ( i < 0 || i>m-1 || j <0 || j> n-1 || board[i][j] != 'O') return;
        queue.offer(i*n+j);
        board[i][j] = '#';
    }
}