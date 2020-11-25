import java.util.HashMap;
import java.util.Map;

class Solution {

    //Time Complexity:O(n)
    //Space Complexity:O(n)
    public boolean isValidSudoku(char[][] board) {
        //判断每一行
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board[i])) {
                return false;
            }
        }
        //判断每一列
        for (int i = 0; i < 9; i++) {
            if (!isValidCol(i, board)){
                return false;
            }
        }
        //判断3*3矩阵
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if (!isValidSmall(i, j, board)){
                    return false;
                }
            }
        }
        return true;

    }

    private boolean isValidRow(char[] board){
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            if (board[i] != '.'){
                if (map.containsKey(board[i])){
                    return false;
                }else {
                    map.put(board[i], 1);
                }
            }
        }
        return true;
    }
    
    private boolean isValidCol(int col, char[][] board){
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            char c = board[i][col];
            if (c != '.'){
                if (map.containsKey(c)){
                    return false;
                }else {
                    map.put(c, 1);
                }
            }
        }
        return true;
    }

    private boolean isValidSmall(int row, int col, char[][] board){
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[row + i][col + j];
                if (c != '.'){
                    if (map.containsKey(c)){
                        return false;
                    }else {
                        map.put(c, 1);
                    }
                }
            }
        }
        return true;
    }
}