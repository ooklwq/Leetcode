import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    //Time Complexity: (n!)
    //Space Complexity: O(n)
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        backtrack(res, nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums,boolean[] used,List<Integer> curList){
        if (curList.size() == nums.length){
            res.add(new ArrayList<>(curList));
            return;
        }
        int preNum = nums[0] - 1;
        for (int i = 0; i < nums.length; i++) {
            if (!used[i] && nums[i] != preNum){
                preNum = nums[i];
                curList.add(nums[i]);
                used[i] = true;
                backtrack(res, nums, used, curList);
                used[i] = false;
                curList.remove(curList.size()-1);
            }
        }
    }
}