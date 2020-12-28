class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int zero = -1; //[0...zero]存储所有0
        int two = n;//[two...n-1]存储所有2
        int i = 0;//[zero+1...i - 1]存储所有1
        while (i < two) {
            if (nums[i] == 1) {
                i ++;
            } else if (nums[i] == 2) {
                swap(nums, i, -- two);
            } else {
                swap(nums, ++ zero, i ++);
            }
        }
//        int zero = 0; //[0...zero)存储所有0
//        int two = n - 1;//(two...n-1]存储所有2
//        int i = 0;//[zero+1...i)存储所有1
//        while (i <= two) {
//            if (nums[i] == 1) {
//                i ++;
//            } else if (nums[i] == 2) {
//                swap(nums, i, two --);
//            } else {
//                swap(nums, zero ++, i ++);
//            }
//        }
    }

    private void swap(int nums[], int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}