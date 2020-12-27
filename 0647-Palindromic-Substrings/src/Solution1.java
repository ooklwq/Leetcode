class Solution1 {

    //Time Complexity: O(n^2)
    //Space Complexity: O(1)
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += extendPalindromic(s, i, i);
            res += extendPalindromic(s, i, i + 1);
        }
        return res;
    }

    private int extendPalindromic(String s, int l, int r) {
        int count = 0;
        while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count ++;
            l --;
            r ++;
        }
        return count;
    }
}