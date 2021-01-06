class Solution {

    //Time Complexity: O(logn)
    //Space Complexity: O(1)
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (target > nums[right]) {
            return right + 1;
        } else if (target <= nums[left]) {
            return left;
        } else {
            return right;
        }
    }
}