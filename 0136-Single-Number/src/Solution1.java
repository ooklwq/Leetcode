import java.util.ArrayList;
import java.util.List;

class Solution1 {
    //Time Comlexity: O(n)
    //Space Complexity: O(1)
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 1, 2};
        System.out.println(new Solution1().singleNumber(nums1));//1
        int[] nums2 = {1, 2, 1, 2,4};
        System.out.println(new Solution1().singleNumber(nums2));//4
    }
}