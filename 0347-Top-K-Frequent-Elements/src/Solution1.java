import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int num : map.keySet()){
            int frequency = map.get(num);
            if (buckets[frequency] == null){
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(num);
        }

        List<Integer> res = new ArrayList<>();
//        for (int i = buckets.length - 1;  i>0 && res.size()<k; i--) {
//            if (buckets[i] != null){
//                res.addAll(buckets[i]);
//            }
//        }
        for (int i = buckets.length - 1; i >0 ; i--) {
            List<Integer> bucket = buckets[i];
            for (int j = 0; j < bucket.size() && res.size() < k ; j++) {
                res.add(bucket.get(j));
            }

        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = res.get(i);
        }
        return ans;

    }
}