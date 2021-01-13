import java.util.HashMap;
import java.util.Map;

class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int val = map.get(c);
            if (i == n - 1 || map.get(s.charAt(i + 1)) <= val) {
                res += val;
            } else {
                res -= val;
            }
        }
        return res;
    }
}