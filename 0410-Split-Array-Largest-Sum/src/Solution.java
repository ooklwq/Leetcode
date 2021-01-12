class Solution {

    //Time Complexity: O(nlogM) M为数组和
    //Space Complexity: O(1)
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        int left = max, right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canSplit(int[] nums, int m, int sum) {
        int count = 1, curSum = 0;
        for (int num : nums) {
            curSum += num;
            if (curSum > sum) {
                curSum = num;
                count ++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}