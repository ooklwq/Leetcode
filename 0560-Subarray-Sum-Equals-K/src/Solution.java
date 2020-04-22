class Solution {

    //Time Complexity: O(n^2)
    //Space Complexity: O(1)
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k) count ++;
            for (int j = i + 1 ; j< nums.length; j++){
                sum += nums[j];
                if (sum == k) count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(new Solution().subarraySum(nums, k));//2
    }
}