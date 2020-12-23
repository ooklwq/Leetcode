class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }


    private int rob(int[] nums, int first, int last){
        int[] memo = new int[nums.length];
        if (nums.length == 2 && first == 1) return nums[first];
        memo[first] = nums[first];
        memo[first + 1] = Math.max(nums[first], nums[first + 1]);
        for (int i = first + 2; i <= last; i++) {
            memo[i] = Math.max(memo[i - 2] + nums[i], memo[i - 1]);
        }
        return memo[last];
    }
}