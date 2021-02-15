import java.util.LinkedList;
import java.util.List;

class Solution {

    //Time Complexity: O(m * n)
    //Space Complexity: O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        int up = 0, down = m - 1;
        int left = 0, right = n - 1;
        while (res.size() < m * n) {
            for (int j = left; j <= right && res.size() < m * n ; j ++) {
                res.add(matrix[up][j]);
            }
            for (int i = up + 1; i <= down - 1 && res.size() < m * n ; i ++) {
                res.add(matrix[i][right]);
            }
            for (int j = right; j >= left && res.size() < m * n ; j --) {
                res.add(matrix[down][j]);
            }
            for (int i = down - 1; i >= up + 1 && res.size() < m * n ; i --) {
                res.add(matrix[i][left]);
            }
            left ++;
            right --;
            up ++;
            down --;
        }
        return res;
    }
}