import java.util.HashSet;
import java.util.Set;

class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(k)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
            //维持set的大小为k
            if (set.size() == k + 1) {
                set.remove(nums[i - k]);
            }
        }
//        for (int i = 0; i < nums.length; i++) {
//            if (i > k) {
//                set.remove(nums[i - k - 1]);
//            }
//            if (!set.add(nums[i])) {
//                return true;
//            }
//        }
        return false;
    }
}