import java.util.Arrays;

class Solution1 {

    //Time Complexity: O(m*n)
    //Space Complexity: O(m*n)
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int res = 0;
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return minDistance(word1, word2, m, n, memo);
    }

    private int minDistance(String word1, String word2, int m, int n, int[][] memo) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        int res = 0;
        if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
            res = minDistance(word1, word2, m - 1, n - 1, memo);
        } else {
            res = Math.min(Math.min(minDistance(word1, word2, m - 1, n, memo),
                    minDistance(word1, word2, m, n - 1, memo)),
                    minDistance(word1, word2, m - 1, n - 1, memo)) + 1;
        }
        memo[m][n] = res;
        return res;
    }
}