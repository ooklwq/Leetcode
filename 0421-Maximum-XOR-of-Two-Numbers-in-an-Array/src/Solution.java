import java.util.HashSet;
import java.util.Set;

class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(mask & num);
            }
            int temp = res | (1 << i);
            for (int prefix : set) {
                if (set.contains(temp ^ prefix)) {
                    res = temp;
                    break;
                }
            }
        }
        return res;
    }
}