class Solution {

    //Time Complexity: O(nlogn)
    //Space Complexity: O(1)
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 1, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count ++;
                }
            }
            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        int res = new Solution().findDuplicate(nums);
        System.out.println(res);
    }
}