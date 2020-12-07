import java.util.ArrayList;
import java.util.List;

class Solution {

    //Time Complexity:(n*2^n)
    //Space Complexity:O(n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        //Arrays.sort(nums);
        backtrack(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> subset, int index){
        res.add(new ArrayList<>(subset));
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, res, subset, i+1);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Solution().subsets(new int[]{1,2,3});
    }

}