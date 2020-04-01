import java.util.HashMap;
import java.util.Map;

class Solution {
    //Time Comlexity: O(n)
    //Space Complexity: O(n)
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1) return nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 2, 1};
        System.out.println(new Solution().singleNumber(nums1));//1
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println(new Solution().singleNumber(nums2));//4
    }
}