import java.util.Arrays;

class Solution {

    //Time Complexity: O(nlogM) (M为最大的距离)
    //Space Complexity: O(1)
    public int smallestDistancePair(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k <= 0) {
            return -1;
        }
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0, right = nums[n - 1] - nums[0] + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0, start = 0;
            for (int i = 0; i < n; i++) {
                while (start < n && nums[i] - nums[start] > mid) {
                    start ++;
                }
                count += i - start;
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}