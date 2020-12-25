import java.util.HashMap;
import java.util.Map;

class Solution1 {

    private Map<String, Integer> map;
    //Time Complexity: O(n*S)
    //Space Complexity: O(n)
    public int findTargetSumWays(int[] nums, int S) {
        int cur_sum = 0;
        int index = 0;
        map = new HashMap<>();
        return findTargetSumWays(nums, S, index, cur_sum);
    }

    private int findTargetSumWays(int[] nums, int S, int index, int cur_sum) {
        String encodeStr = index + "->" + cur_sum;
        if (map.containsKey(encodeStr)) {
            return map.get(encodeStr);
        }
        if (index == nums.length && cur_sum == S) {
            return 1;
        }
        if (index == nums.length) {
            return 0;
        }
        int pos = findTargetSumWays(nums, S, index + 1, cur_sum + nums[index]);
        int neg = findTargetSumWays(nums, S, index + 1, cur_sum - nums[index]);
        map.put(encodeStr, pos + neg);
        return pos + neg;
    }
}