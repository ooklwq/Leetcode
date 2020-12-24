import java.util.Arrays;

class Solution {

    //Time Complexity: O(n*C)
    //Space Complexity: O(c)
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i]){
                    dp[j] = Math.min(dp[j], dp[j- coins[i]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int res = new Solution().coinChange(new int[]{1,2,5},11);
        System.out.println(res);
    }
}