import java.util.TreeSet;

class Solution {

    //Time Complexity: O(nlogn)
    //Space Complexity: O(n)
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length ==  0) {
            return 0;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        if (set.size() < 3) {
            return set.last();
        }
        set.remove(set.last());
        set.remove(set.last());
        return set.last();
    }
}