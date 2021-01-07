class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int fast = 0, slow = 0;
        while (true){
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) {
                break;
            }
        }
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        int res = new Solution().findDuplicate(nums);
        System.out.println(res);
    }
}