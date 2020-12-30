import java.util.TreeSet;

class Solution {

    //Time Complexity: O(nlogk)
    //Space Complexity: O(k)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceil = set.ceiling(new Long(nums[i]) - new Long(t));
            if (ceil != null && ceil <= new Long(nums[i]) + new Long(t)) {
                return true;
            } else {
                set.add(new Long(nums[i]));
            }
            //维持set的大小为k
            if (set.size() == k + 1) {
                set.remove(new Long(nums[i - k]));
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] nums = new int[] {2147483640,2147483641};
        int k = 1, t = 100;
        new Solution().containsNearbyAlmostDuplicate(nums, k, t);
    }
}