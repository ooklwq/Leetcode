class Solution1 {

    //Time Complexity: O(logn)
    //Space Complexity: O(1)
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int start = firtGreaterEqual(nums, target);
        if (start == nums.length || nums[start] != target) {
            return res;
        }
        res[0] = start;
        res[1] = firtGreaterEqual(nums, target + 1) - 1;
        return res;
    }

    private int firtGreaterEqual(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}