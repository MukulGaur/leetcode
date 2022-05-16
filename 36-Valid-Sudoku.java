// Solution 1 - RunTime 2ms

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> res = new HashSet<>();
        
        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                if(board[row][col]=='.')
                    continue;
                if(!isValid(board, row, col))
                    return false;
            }
        }
        
        return true;
        
    }
    
    private boolean isValid(char[][] board, int row, int col){
        for(int i = 0; i < 9; ++i){
            if(i != col && board[row][col] == board[row][i])
                return false;
            
            if(i != row && board[i][col] == board[row][col])
                return false;
            
            int r = 3 * (row / 3) + (i / 3);
            int c = 3 * (col / 3) + (i % 3);
            
            if(r != row && c != col && board[r][c] == board[row][col])
                return false;
        }
        
        return true;
    }
}
