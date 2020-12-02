class Solution {
    private int res = 0;
    private boolean[] cols;
    private boolean[] dia1;
    private boolean[] dia2;

    public int totalNQueens(int n) {
        if (n <= 0) return 0;
        cols = new boolean[n];
        dia1 = new boolean[2*n-1];
        dia2 = new boolean[2*n-1];
        putQueens(n, 0);
        return res;
    }

    private void putQueens(int n, int index){
        if (index == n){
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!cols[i] && !dia1[index+i] && !dia2[index-i+n-1]){
                cols[i] = true;
                dia1[index+i] = true;
                dia2[index-i+n-1] = true;
                putQueens(n, index+1);
                dia2[index-i+n-1] = false;
                dia1[index+i] = false;
                cols[i] = false;
            }
        }
    }


}