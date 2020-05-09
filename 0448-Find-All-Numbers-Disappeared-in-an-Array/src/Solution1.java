import java.util.ArrayList;
import java.util.List;

class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]) - 1;
            if (nums[num] > 0){
                nums[num] = - nums[num];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                res.add(i + 1);
            }
        }
        return res;
    }
}