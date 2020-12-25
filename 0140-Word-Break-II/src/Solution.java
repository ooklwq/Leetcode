import java.util.*;

class Solution {

    //Time Complexity: O(n^2)
    //Space Complexity: O(n)
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (String str : wordDict) {
            set.add(str);
        }
        HashMap<String, List<String>> memo = new HashMap<>();
        return wordBreak(s, set, memo);
    }

    private List<String> wordBreak(String s, Set<String> set, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        if (s.length() == 0) {
            return null;
        }
        List<String> res = new LinkedList<>();
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            List<String> partRes = null;
            if (set.contains(sub)) {
                partRes = wordBreak(s.substring(i), set, memo);
                //当前字符串就是字典中的一个词
                if (partRes == null) {
                    res.add(sub);
                } else {
                    for (String str : partRes) {
                        res.add(sub + " " + str);
                    }
                }
//                System.out.println(sub);
//                System.out.println(partRes == null);
            }
        }
        memo.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> list = new LinkedList<>();
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("cat");
        List<String> res = new Solution().wordBreak(s, list);
        for (String str: res) {
            System.out.println(str);
        }
    }
}