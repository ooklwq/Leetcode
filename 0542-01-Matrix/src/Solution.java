import java.util.LinkedList;
import java.util.Queue;

class Solution {

    //Time Complexity: O(m*n)
    //Space Complexity: O(m*n)
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : dirs) {
                int row = cell[0] + dir[0];
                int col = cell[1] + dir[1];
                if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) {
                    continue;
                }
                visited[row][col] = true;
                matrix[row][col] = matrix[cell[0]][cell[1]] + 1;
                queue.offer(new int[] {row, col});
            }
        }
        return matrix;
    }
}