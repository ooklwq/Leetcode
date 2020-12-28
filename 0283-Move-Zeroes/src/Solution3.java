class Solution3 {
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public void moveZeroes(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != pos) { //防止数组中所有元素都为非0
                    int temp = nums[pos];
                    nums[pos++] = nums[i];
                    nums[i] = temp;
                } else {
                    pos ++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new Solution3().moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }//[1,3,12,0,0]
    }
}