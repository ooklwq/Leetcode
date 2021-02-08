import java.util.HashSet;
import java.util.Set;

class Solution {

    //Time Complexity: O(j+s)
    //Space Complexity: O(j)
    public int numJewelsInStones(String jewels, String stones) {
        if (jewels == null || jewels.isEmpty() || stones == null || stones.isEmpty()) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                res ++;
            }
        }
        return res;
    }
}