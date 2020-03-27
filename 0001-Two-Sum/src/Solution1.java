import java.util.HashMap;
import java.util.Map;

class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                results[1] = i;
                results[0] = map.get(target - nums[i]);
            }else {
                map.put(nums[i], i);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] results = new Solution1().twoSum(nums, target);
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }
}