import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {
    //BFS
    int rows;
    int cols;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length ==0) return 0;
        int count = 0;
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]){
                    bfs(grid, visited, i, j);
                    count ++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid,boolean[][] visited, int i, int j){
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0,1}};
//        grid[i][j] = 0;
        visited[i][j] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i * cols + j);
        while (!queue.isEmpty()){
            int code = queue.poll();
            i = code / cols;
            j = code % cols;
            for (int[] direction : directions) {
                int x = i + direction[0];
                int y = j + direction[1];
                if (x >=0 && x < rows && y >=0 && y < cols && grid[x][y] == '1' && !visited[x][y]){
                    queue.offer(x * cols + y);
                    visited[x][y] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1','1','0'},
                {'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(new Solution3().numIslands(grid));
    }


}