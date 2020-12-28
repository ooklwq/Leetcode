import java.util.HashSet;

class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        int i = 0, j = 0; //[i, j) 滑动窗口
        HashSet<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j ++));
                res = Math.max(res, set.size());
            } else {
                set.remove(s.charAt(i ++));
            }
        }
        return res;
//        int i = 0, j = -1; //[i, j] 滑动窗口
//        HashSet<Character> set = new HashSet<>();
//        while (i < s.length()) {
//            if (j + 1 < s.length() && !set.contains(s.charAt(j + 1))) {
//                set.add(s.charAt( ++j));
//                res = Math.max(res, set.size());
//            } else {
//                set.remove(s.charAt(i ++));
//            }
//        }
//        return res;
    }
}