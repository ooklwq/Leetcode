class Solution {

    //Time Complexity: O(2^n)
    //Space Complexity: O(n)
    public int findTargetSumWays(int[] nums, int S) {
        int cur_sum = 0;
        int index = 0;
        return findTargetSumWays(nums, S, index, cur_sum);
    }

    private int findTargetSumWays(int[] nums, int S, int index, int cur_sum) {
        if (index == nums.length && cur_sum == S) {
            return 1;
        }
        if (index == nums.length) {
            return 0;
        }
        int pos = findTargetSumWays(nums, S, index + 1, cur_sum + nums[index]);
        int neg = findTargetSumWays(nums, S, index + 1, cur_sum - nums[index]);
        return pos + neg;
    }
}