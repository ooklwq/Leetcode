class Solution {

    //Time Complexity: O(n*k)
    //Space Complexity: O(k)
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        int res = n;
        for (int i = n - 1; i > 1; i --) {
            if (n % i == 0) {
                res = Math.min(res, minSteps(n / i) + i);
            }
        }
        return res;
    }
}