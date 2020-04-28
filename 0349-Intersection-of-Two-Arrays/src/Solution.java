import java.util.ArrayList;
import java.util.HashSet;

class Solution {

    //Time Complexity: O(m + n)
    //Space Complexity: O(max(m,n))
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) set.add(num);
        ArrayList<Integer> res = new ArrayList();
        for (int num : nums2){
            if (set.contains(num)) {
                res.add(num);
                set.remove(num);
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int)res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] results1 = new Solution().intersection(nums1, nums2);//[2]
        for (int num : results1) System.out.println(num);
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        int[] results2 = new Solution().intersection(nums3, nums4);//[2]
        for (int num : results2) System.out.println(num);
    }
}