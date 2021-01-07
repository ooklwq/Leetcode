class Solution1 {

    //Time Complexity: O(nlogn)
    //Space Complexity: O(n)
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int left = 0, right = size;
            while (left != right) {
                int m = left + (right - left) / 2;
                if (tails[m] < num)
                    left = m + 1;
                else
                    right = m;
            }
            tails[left] = num;
            if (left == size) ++size;
        }
        return size;
    }

}