public class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int farthest = 0;//当前位置能达到的最远距离
//        for (int i = 0; i < n - 1; i++) {
//            farthest = Math.max(farthest, i + nums[i]);
//            if (farthest <= i) {
//                return false;
//            }
//        }
//        return farthest >= n - 1;
        for (int i = 0; i < n; i++) {
            if (i > farthest || farthest >= n - 1) break;
            farthest = Math.max(farthest, i + nums[i]);
        }
        return farthest >= n- 1;
    }
}