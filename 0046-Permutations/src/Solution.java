import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> res;

    //Time Complexity: (n!)
    //Space Complexity: O(n)
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if (nums.length == 0) return res;
        permute(nums, 0, new ArrayList<>());
        return res;
}

    private void permute(int nums[], int index, ArrayList<Integer> p){
        if (index == nums.length){
            res.add(new ArrayList<>(p));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (p.contains(nums[i])) continue;
            p.add(nums[i]);
            permute(nums, index + 1, p);
            p.remove(p.size() - 1);
        }

    }
}