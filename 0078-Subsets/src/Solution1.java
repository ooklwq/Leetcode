import java.util.ArrayList;
import java.util.List;

class Solution1 {

    //Time Complexity:(n*2^n)
    //Space Complexity:O(n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        for (int i = 0; i <= nums.length ; i++) {
            backtrack(nums, res, new ArrayList<>(), 0, i);
        }
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> subset, int index, int n){
        if (n == subset.size()) {
            res.add(new ArrayList<>(subset));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, res, subset, i+1, n);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Solution().subsets(new int[]{1,2,3});
    }

}