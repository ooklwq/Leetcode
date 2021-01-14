import java.util.LinkedList;
import java.util.List;

class Solution {

    //Time Complexity: O(n*2^n)
    //Space Complexity: O(n)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        backtrack(res, candidates, target, 0, new LinkedList<>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] candidates, int target, int index, List<Integer> temp){
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new LinkedList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(res, candidates, target - candidates[i], i, temp);
            temp.remove(temp.size() - 1);
        }

    }


}