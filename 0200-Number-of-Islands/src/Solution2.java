public class Solution2 {
    //DFS with visited.
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
                    dfs(grid, visited, i, j);
                    count ++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid,boolean[][] visited,int i, int j){
        if (i < 0 || i >= rows || j <0 || j >= cols || grid[i][j] != '1' || visited[i][j]) return;
        //Visited.
        visited[i][j] = true;
        dfs(grid, visited,i - 1, j);//top
        dfs(grid, visited,i + 1, j);//down
        dfs(grid, visited, i, j - 1);//left
        dfs(grid, visited, i, j + 1);//right

    }

}