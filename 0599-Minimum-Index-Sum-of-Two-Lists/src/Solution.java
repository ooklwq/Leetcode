import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new LinkedList<>();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int j = map.get(list2[i]);
                if (i + j < minSum) {
                    minSum = i + j;
                    res = new LinkedList<>();
                    res.add(list2[i]);
                } else if (i + j == minSum) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}