class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int res = n + 1;
        int left = 0, right = -1; //[i, j]滑动窗口
        int sum = 0;
        while (left < n) {
            if (right + 1 < n && sum < s) {
                sum += nums[++ right];
            } else {
                sum -= nums[left ++];
            }

            if (sum >= s) {
                res = Math.min(res, right - left + 1);
            }
        }
        if (res == n + 1) {
            return 0;
        }
        return res;
    }
}