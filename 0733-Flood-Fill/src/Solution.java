class Solution {
    private int rows;
    private int cols;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }
        if (image[sr][sc] == newColor) {
            return image;
        }
        rows = image.length;
        cols = image[0].length;
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc,int color, int newColor){
        if (sr < 0 || sr >= rows || sc < 0 || sc >= cols || color != image[sr][sc]) {
            return;
        }
        image[sr][sc] = newColor;
        dfs(image, sr - 1, sc, color, newColor);//up
        dfs(image, sr + 1, sc, color, newColor);//down
        dfs(image, sr, sc - 1, color, newColor);//left
        dfs(image, sr, sc + 1, color, newColor);//right
    }
}