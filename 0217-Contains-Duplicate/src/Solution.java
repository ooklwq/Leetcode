import java.util.HashSet;
import java.util.Set;

class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        //if (set.size() < nums.length) return true;
        return false;
    }

}