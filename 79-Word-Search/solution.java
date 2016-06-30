public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i< board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if(findword(i,j,board,word, 0)) return true;
            }
        }
        return false;
    }
    
    public boolean findword(int i, int j, char[][] board, String word, int index){
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || i == board.length || j == board[i].length) return false;
        if (board[i][j]!= word.charAt(index)) return false;
        board[i][j] ^= 256;
        boolean exist = findword(i, j-1, board, word, index+1) || findword( i, j+1, board, word, index+1)
                        || findword(i-1, j, board, word, index+1) || findword(i+1, j, board, word, index+1);
        board[i][j] ^= 256;
        return exist;
        
    }
}