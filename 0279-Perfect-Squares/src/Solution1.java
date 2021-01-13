import java.util.Arrays;

class Solution1 {

    //Time Complexity: O(n^2)
    //Space Complexity: O(n)
    //BFS 图的最短路径
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        //dp[i]表示i至少有多少个完全平方数表示
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}