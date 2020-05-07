import java.util.HashMap;

class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int major = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)){
                map.put(num, 1);
            }else {
                map.put(num, map.get(num) + 1);
            }
            if (map.get(num) > nums.length/2){
                major = num;
                break;
            }
        }
        return major;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        System.out.println(new Solution().majorityElement(nums1)); //3
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new Solution().majorityElement(nums2)); //2
    }
}