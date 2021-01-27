class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int res = nums[0];
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }



    public static void main(String[] args) {
        int[] nums = {-2,3,-4};
        int res = new Solution().maxProduct(nums);
        System.out.println(res);
    }
}