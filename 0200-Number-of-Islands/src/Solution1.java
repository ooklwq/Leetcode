public class Solution1 {
    //DFS without visited.
    int rows;
    int cols;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length ==0) return 0;
        int count = 0;
        rows = grid.length;
        cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count ++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j){
        if (i < 0 || i >= rows || j <0 || j >= cols || grid[i][j] != '1') return;
        //Visited. If you don't want to modify the input, you can change it to 's'.
        //After finishing all visit, change it back.
        grid[i][j] = '0';
        dfs(grid, i - 1, j);//top
        dfs(grid, i + 1, j);//down
        dfs(grid, i, j - 1);//left
        dfs(grid, i, j + 1);//right

    }

}