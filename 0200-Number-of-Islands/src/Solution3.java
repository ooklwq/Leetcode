import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    //BFS
    int rows;
    int cols;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length ==0) return 0;
        int count = 0;
        rows = grid.length;
        cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' ){
                    bfs(grid, i, j);
                    count ++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j){
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0,1}};
        grid[i][j] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()){
//            i = queue.poll()[0];
//            j = queue.poll()[1]; //poll一次就没了。。。NullPointer
            int[] cur = queue.poll();
            for (int[] direction : directions) {
                int x = cur[0] + direction[0];
                int y = cur[1] + direction[1];
//                int x = i + direction[0];
//                int y = j + direction[1];
                if (x >=0 && x < rows && y >=0 && y < cols && grid[x][y] == '1'){
                    queue.offer(new int[]{x, y});
                    grid[x][y] = '0';
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