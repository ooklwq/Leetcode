class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                res = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] * 2 > max && i != res) {
                return -1;
            }
        }
        return res;
    }

}