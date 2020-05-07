class Solution3 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int majorityElement(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < 32; i++) {
            int zeros = 0, ones = 0; //记录每个Bit中0和1的个数
            for (int num : nums) {
                if (zeros > n/2 || ones > n/2) break;
                if ((num & (1<<i)) != 0) ones++;
                else zeros++;
            }
            if (ones > zeros) res |= 1 << i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        System.out.println(new Solution().majorityElement(nums1)); //3
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new Solution().majorityElement(nums2)); //2
    }
}