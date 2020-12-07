import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    //Time Complexity:(n*2^n)
    //Space Complexity:O(n)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        backtrack(res, nums, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int index, List<Integer> subset){
        res.add(new ArrayList<>(subset));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            backtrack(res, nums, i+1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}