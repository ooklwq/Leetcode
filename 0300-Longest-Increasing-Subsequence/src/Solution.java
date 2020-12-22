import java.util.Arrays;

class Solution {

    //Time Complexity: O(n^2)
    //Space Complexity: O(n)
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //memo[i]表示已该字符结尾的最长上升子序列的长度
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);
        for (int i = 1; i < memo.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < memo.length ; i++) {
            res = Math.max(res, memo[i]);
        }
        return res;
    }

}