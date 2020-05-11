import java.util.Arrays;

class Solution {

    //Time Complexity: O(nlogn)
    //Space Complexity: O(h)
    //QuickSort
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}