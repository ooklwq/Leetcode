class Solution2 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int size = 0;
            while (num > 0) {
                size ++;
                num = num / 10;
            }
            if (size % 2 == 0) {
                res ++;
            }
        }
        return res;
    }
}