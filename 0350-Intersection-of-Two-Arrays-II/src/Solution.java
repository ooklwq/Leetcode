import java.util.ArrayList;
import java.util.HashMap;

class Solution {

    //Time Complexity: O(m + n)
    //Space Complexity: O(max(m,n)
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int num : nums2){
            if (map.containsKey(num)){
                res.add(num);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) map.remove(num);
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}