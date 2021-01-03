class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int n = nums.length;
        int[] res = new int[n];
        int i = 0, j = n - 1;
        for (int k = n - 1; k >= 0; k--) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                res[k] = nums[i] * nums[i];
                i ++;
            } else {
                res[k] = nums[j] * nums[j];
                j --;
            }
        }
        return res;
    }
}