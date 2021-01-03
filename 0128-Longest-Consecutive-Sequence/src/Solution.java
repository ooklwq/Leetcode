import java.util.HashSet;
import java.util.Set;

class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int next = num + 1;
                while (set.contains(next)) {
                    next ++;
                }
                res = Math.max(res, next - num);
            }
        }
        return res;
    }
}