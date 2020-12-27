class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int maxSubArray(int[] nums) {
        int max = nums[0], curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i] + curSum, nums[i]);
            max = Math.max(max, curSum);
        }
        return max;
    }
}