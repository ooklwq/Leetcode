import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    //Time Complexity: O(n^2)
    //Space Complexity: O(1)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = n - 1;
            int target = 0 - nums[i];
            while (left < right) {
                int val = nums[left] + nums[right];
                if (val == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left ++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right --;
                    }
                    left ++;
                    right --;
                } else if (val > target) {
                    right --;
                } else {
                    left ++;
                }
            }
        }
        return res;

    }
}