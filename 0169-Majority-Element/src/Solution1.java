class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    //Moore voting algorithm
    public int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0){
                count++;
                major = nums[i];
            }else if (major == nums[i]){
                count++;
            }else {
                count--;
            }
        }
        return major;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        System.out.println(new Solution().majorityElement(nums1)); //3
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new Solution().majorityElement(nums2)); //2
    }
}