import java.util.HashMap;
import java.util.Map;

class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c: t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            else {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) map.remove(c);
            }
        }
        return map.size() == 0;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(new Solution1().isAnagram(s, t));
    }
}