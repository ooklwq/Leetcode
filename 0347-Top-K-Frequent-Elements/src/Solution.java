import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

    //Time Complexity: O(nlogk)
    //Space Complexity: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
//            if (map.containsKey(num)){
//                map.put(num, map.get(num) + 1);
//            }else {
//                map.put(num, 1);
//            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

//        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return map.get(o1) - map.get(o2);
//            }
//        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b)
        );
        for (int num : map.keySet()){
            if (pq.size() < k){
                pq.add(num);
            }else if (map.get(num) > map.get(pq.peek())){
                pq.remove();
                pq.add(num);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove();
        }
        return res;
    }
}