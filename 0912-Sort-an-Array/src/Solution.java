class Solution {

    //MergeSort
    //Time Complexity:O(nlogn)
    //Space Complexity:O(n)
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp){
        if (left >= right) return;
        int mid = left + (right - left)/2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid+1, right, temp);
        merge(nums, left, mid, right, temp);
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp){
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <=right ){
            if (nums[i] > nums[j]){
                temp[k++] = nums[j++];
            }else {
                temp[k++] = nums[i++];
            }
        }
        while (i <= mid){
            temp[k++] = nums[i++];
        }
        while (j <= right){
            temp[k++] = nums[j++];
        }
        for (i = left; i<= right; i++){
            nums[i] = temp[i];
        }
    }
}