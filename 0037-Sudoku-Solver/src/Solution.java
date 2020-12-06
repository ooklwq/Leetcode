class Solution {

    //Time Complexity: O(9^m)
    //Space Complexity:O(m)
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        solveSudoku(board, 0, 0);
    }

    private boolean solveSudoku(char[][] board, int i, int j){
        if (i == 9){
            return true;
        }
        //检测下一行
        if (j == 9){
            return solveSudoku(board, i+1, 0);
        }
        if (board[i][j] != '.') {
            return solveSudoku(board, i, j+1);
        }
        for (char c = '1'; c <= '9'; c++) {
            if (!isValid(board, i, j, c)) continue;
            board[i][j] = c;
            if (solveSudoku(board, i, j+1)) return true;
            board[i][j] = '.';
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j, char c){
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c) return false;
            if (board[k][j] == c) return false;
            if (board[(i/3)*3 + k/3][(j/3)*3 + k%3] == c) return false;
        }
        return true;
    }

}