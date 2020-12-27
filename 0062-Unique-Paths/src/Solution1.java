class Solution1 {

    //Time Complexity: O(m)
    //Space Complexity: O(1)
    public int uniquePaths(int m, int n) {
        int N = m + n - 2;// 总共要走的步数
        int k = m - 1; //向下走的步数
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (N - k + i) / i;
        }
        return (int)res;
    }
}