import java.util.Arrays;

class Solution2 {

    //Time Complexity: O(nlogn)
    //Space Complexity: O(1)
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        System.out.println(new Solution().majorityElement(nums1)); //3
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new Solution().majorityElement(nums2)); //2
    }
}