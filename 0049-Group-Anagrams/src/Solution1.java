import java.util.*;

class Solution1 {
    //Time Complexity: O(nk) n为字符串数组长度，k为字符串最长字符个数，klogk为排序复杂度
    //Space Complexity:  O(nk)
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0 || strs == null) return new ArrayList<>();
        Map<String, List> res = new HashMap<>();
        for (String str : strs) {
            char[] count = new char[26];
            for (char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }
            String key = String.valueOf(count);
            if (!res.containsKey(key)){
                res.put(key, new ArrayList());
            }
            res.get(key).add(str);
        }
        return new ArrayList(res.values());
    }
}