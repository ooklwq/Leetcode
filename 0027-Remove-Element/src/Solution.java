class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int begin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[begin ++] = nums[i];
            }
        }
        return begin;
    }
}