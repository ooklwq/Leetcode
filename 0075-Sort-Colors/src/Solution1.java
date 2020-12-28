class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    //Counting Sort
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int[] colors = new int[3];
        for (int i = 0; i < n; i++) {
            colors[nums[i]] ++;
        }
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < colors[i]; j++) {
                nums[index ++] = i;
            }
        }
    }

    private void swap(int nums[], int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}