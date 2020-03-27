class Solution {

    //Time Complexity: O(n^2)
    //Space Complexity: O(1)
    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    results[0] = i;
                    results[1] = j;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] results = new Solution().twoSum(nums, target);
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }
}