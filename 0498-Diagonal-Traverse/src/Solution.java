class Solution {

    //Time Complexity: O(m * n)
    //Space Complexity: O(1)
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = 0, dirction = 1;
        int[] res = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            res[i] = matrix[row][col];
            row -= dirction;
            col += dirction;

            if (row >= m) {row = m - 1; col += 2; dirction = - dirction;}
            if (col >= n) {col = n - 1; row += 2; dirction = - dirction;}
            if (row < 0) {row = 0; dirction = - dirction;}
            if (col < 0) {col = 0; dirction = -dirction;}
        }
        return res;
    }
}