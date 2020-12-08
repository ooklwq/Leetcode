class Solution {
    private int[] memo;

    //Time Complexity:(n^2)
    //Space Complexity:O(n)
    public int integerBreak(int n) {
        memo = new int[n+1];
        return breakInteger(n);
    }

    private int breakInteger(int n){
        if (n == 1) return 1;
        if (memo[n] != 0) return memo[n];
        memo[1] = 1;
        for (int i = 2; i <= n  ; i++) {
            for (int j = 1; j <= i-1; j++) {
                memo[i] = Math.max(memo[i], Math.max(j*(i-j), j*memo[i-j]));
            }

        }
        return memo[n];
    }


}