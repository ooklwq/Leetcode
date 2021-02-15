import java.util.Arrays;

class Solution {

    //Time Complexity: O(nlogn)
    //Space Complexity: O(logn)
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }
}