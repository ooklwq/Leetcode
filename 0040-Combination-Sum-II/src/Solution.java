import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    //Time Complexity: O(n*2^n)
    //Space Complexity: O(n)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        backtrack(res, candidates, 0, target, new ArrayList<>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] candidates, int index, int target, List<Integer> temp){
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            backtrack(res, candidates, i + 1, target - candidates[i], temp);
            temp.remove(temp.size() - 1);
        }
    }
}