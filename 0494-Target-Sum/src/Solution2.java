class Solution2 {

    //Time Complexity: O(C* n)
    //Space Complexity: O(C)
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (S + sum) % 2 == 1) {
            return 0;
        }
        int C = (S + sum) / 2;
        int[] dp = new int[C + 1];
        dp[0] =  1;
        for (int num : nums) {
            for (int i = C; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[C];
    }

}