class Solution1 {

    //Time Complexity: O(nlogn)
    //Space Complexity: O(n)
    public int lengthOfLIS(int[] nums) {
        // tails[i] 存储长度为 i + 1 的最长递增子序列的最后一个元素
        int[] tails = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            //在tails数字中找第一个不小于num的索引
            int index = binarySearch(tails, size, num);
            //若tails中存在一个数不小于num，则该数被num覆盖，若不存在，相当于直接将num追加到tails数组中
            tails[index] = num;
            if (index == size) ++size;
        }
        return size;
    }

    //查找第一个不小于target的索引，若找不到，则会越右边界
    private int binarySearch(int[] nums, int size, int target) {
        int left = 0, right = size;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}