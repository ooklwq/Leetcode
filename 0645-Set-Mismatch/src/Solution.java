class Solution {

    //Time Compleixty: O(n)
    //Space Complexity: O(1)
    public int[] findErrorNums(int[] nums) {
        // 返回结果dup和missing组成的数组
        int[] res = new int[2];
        for (int i = 0; i< nums.length; i++) {
            //现在的元素是从1开始的
            int index = Math.abs(nums[i]) - 1;
            // 重复访问，找到dup
            if (nums[index] < 0) res[0] = Math.abs(nums[i]);
            else nums[index] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            // 没有访问过，索引加一还原为元素
            if (nums[i] > 0) res[1] = i + 1;
        }
        return res;
    }
}