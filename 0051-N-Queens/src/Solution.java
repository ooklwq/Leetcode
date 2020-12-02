import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> res;
    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>(n);
        if (n <= 0) return res;
        col = new boolean[n];
        dia1 = new boolean[2*n - 1];
        dia2 = new boolean[2*n - 1];
        solveNQueens(n, 0, new ArrayList<>());
        return res;
    }

    //每次摆放第index行，rows[i] = k 存储皇后放在第i行的第k列
    private void solveNQueens(int n, int index, List<Integer> rows){
        if (index == n){
            res.add(generateString(n, rows));
            return;
        }
        //摆放第index行的第i列
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]){
                rows.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                solveNQueens(n, index + 1, rows);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                rows.remove(rows.size() - 1);
            }
        }
    }

    private List<String> generateString(int n, List<Integer> rows){
        ArrayList<String> board = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == rows.get(i)) sb.append("Q");
                else sb.append(".");
            }
            board.add(sb.toString());
        }
        return board;
    }

    public static void main(String[] args) {
        int n = 8;
        List<List<String>> res = new Solution().solveNQueens(n);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(res.get(i).get(j));
            }
            System.out.println();
        }
        System.out.println(res.size());
    }
}