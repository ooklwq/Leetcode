class Solution {

    //Time Complexity: O(n^2)
    //Space Complexity: O(n^2)
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            res ++;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                res ++;
            }
        }
        for (int i = 3; i <= n; i++) {
            for (int j = 0; i + j - 1 < n; j++) {
                if (s.charAt(j) == s.charAt(i + j - 1) && dp[j + 1][i + j - 2]) {
                    dp[j][i + j - 1] = true;
                    res ++;
                }
            }
        }
        return res;
    }
}