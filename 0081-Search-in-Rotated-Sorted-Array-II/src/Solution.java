class Solution {

    //Time Complexity: O(logn)
    //Space Complexity: O(1)
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //右边有序
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[right]){
                //左边有序
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                right --;
            }
        }
        return false;
    }
}