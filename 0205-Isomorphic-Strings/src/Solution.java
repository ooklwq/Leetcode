
class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty()) {
            return true;
        }
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
                return false;
            }
            m1[s.charAt(i)] = m2[t.charAt(i)] = i + 1;
        }
        return true;

    }
}