class Solution {
    private int[][] direction = {{-1,0},{0,1},{1,0},{0,-1}};
    private int m, n;
    private boolean[][] visited;

    private boolean inArea(int x, int y){
        return x >=0 && x < m && y >=0 && y < n;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchWord(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int startX, int startY){
        if (index == word.length() - 1){
            return board[startX][startY] == word.charAt(index);
        }
//        if (index == word.length()){
//            return true;
//        }
        if (board[startX][startY] == word.charAt(index)){
            visited[startX][startY] = true;
//            System.out.println("startX:"+startX+",startY:"+startY+","+board[startX][startY]);
            for (int i = 0; i < 4; i++) {
                int newX = startX + direction[i][0];
                int newY = startY + direction[i][1];
                if (inArea(newX , newY) && !visited[newX][newY]
                        && searchWord(board, word, index+1, newX, newY))
                    return true;
            }
            visited[startX][startY] = false;
        }
        return false;
    }

    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCCED";
        String word = "SEE";
        System.out.println(new Solution().exist(board, word));
    }
}