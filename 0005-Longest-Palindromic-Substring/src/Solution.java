class Solution {

    //Time Complexity: O(n^2)
    //Space Complexity: O(n^2)
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        int start = 0;
        int length = 1;
        //isPalindrome[i][j]表示s[i...j]是否为回文子串
        boolean[][] isPalindrome = new boolean[n][n];
        //初始化
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                start = i;
                length = 2;
            }
        }
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j + i - 1 < n; j++) {
                if (s.charAt(j) == s.charAt(j + i - 1) && isPalindrome[j + 1][j + i - 2]) {
                    isPalindrome[j][j + i - 1] = true;
                    start = j;
                    length = i;
                }
            }
        }
        //状态转移
        System.out.println(start);
        System.out.println(length);
        return s.substring(start, start + length);
    }

    public static void main(String[] args) {
        String s = "babad";
        new Solution().longestPalindrome(s);

    }
}