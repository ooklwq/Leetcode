import java.util.ArrayList;
import java.util.List;

class Solution2 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[(nums[i] - 1) % n] += n;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= n){
                res.add(i + 1);
            }
        }
        return res;
    }
}