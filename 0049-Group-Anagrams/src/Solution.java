import java.util.*;

class Solution {
    //Time Complexity: O(nklogk) n为字符串数组长度，k为字符串最长字符个数，klogk为排序复杂度
    //Space Complexity:  O(nk)
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0 || strs == null) return new ArrayList<>();
        Map<String, List> res = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sortedStr = String.valueOf(ch);
            if (!res.containsKey(sortedStr)){
                res.put(sortedStr, new ArrayList());
            }
            res.get(sortedStr).add(str);
        }
        return new ArrayList<>(res.values());
    }
}