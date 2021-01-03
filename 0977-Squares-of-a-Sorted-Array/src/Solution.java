import java.util.Arrays;

class Solution {

    //Time Complexity: O(nlogn)
    //Space Complexity: O(nlogn)
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}