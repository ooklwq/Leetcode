import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution1 {

    //Time Complexity: O(nlogn)
    //Space Complexity: O(nlogn)
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int cur = nums[0];
        int res = 1;
        int sum = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i] == cur + 1) {
                cur ++;
                sum ++;
                res = Math.max(res, sum);
            } else {
                cur = nums[i];
                sum = 1;
            }
        }
        return res;
    }
}