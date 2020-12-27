class Solution1 {

    //Time Complexity: O(n^2)
    //Space Complexity: O(1)
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        int start = 0;
        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            int curLength = Math.max(getLength(s, i, i), getLength(s, i, i + 1));//奇、偶
            if (curLength > maxLength) {
                maxLength = curLength;
                start = i - (maxLength - 1) / 2;
            }
        }
        return s.substring(start, start + maxLength);
    }

    private int getLength(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l --;
            r ++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        new Solution().longestPalindrome(s);

    }
}