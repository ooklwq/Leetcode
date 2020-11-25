import java.util.HashSet;
import java.util.Set;

class Solution1 {

    //Time Complexity:O(n)
    //Space Complexity:O(n)
    public boolean isValidSudoku(char[][] board) {
        Set set = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.'){
                    if (!set.add(c + " in row " + i)
                            || !set.add(c + " in col " + j)
                            || !set.add(c + " in block " + i / 3 + '-' + j / 3)){
                        return false;
                    }
                }
            }
        }
        return true;

    }
}