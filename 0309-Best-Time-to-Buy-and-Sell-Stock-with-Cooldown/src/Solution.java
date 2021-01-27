class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] hold = new int[n + 1];
        int[] rest = new int[n + 1];
        int[] sold = new int[n + 1];
        hold[0] = Integer.MIN_VALUE;
        rest[0] = 0;
        sold[0] = 0;
        for (int i = 1; i <= n; i++) {
            hold[i] = Math.max(hold[i - 1], rest[i - 1] - prices[i - 1]);
            rest[i] = Math.max(rest[i - 1], sold[i - 1]);
            sold[i] = hold[i - 1] + prices[i - 1];
        }
        return Math.max(rest[n], sold[n]);
    }
}