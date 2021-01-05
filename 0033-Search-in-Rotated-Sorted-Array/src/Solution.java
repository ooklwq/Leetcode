class Solution {

    //Time Complexity: O(logn)
    //Space Complexity: O(1)
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //1.找到最小值所在索引
        int minIndex = findMinIndex(nums);
        //2.判断target在哪一部分
        int n = nums.length;
        int left = 0, right = n - 1;
        if (target <= nums[right]) {
            left = minIndex;
        } else {
            right = minIndex;
        }
        //3.在确定的某个部分寻找target
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int findMinIndex(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        int index = new Solution().findMinIndex(nums);
        System.out.println(index);
    }
}