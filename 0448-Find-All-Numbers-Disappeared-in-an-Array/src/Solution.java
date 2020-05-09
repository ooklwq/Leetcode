import java.util.ArrayList;
import java.util.List;

class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] record = new int[nums.length + 1];
        for (int num : nums) {
            record[num] = 1;
        }
        for (int i = 1; i < record.length; i++) {
            if (record[i] == 0) res.add(i);
        }
        return res;
    }
}