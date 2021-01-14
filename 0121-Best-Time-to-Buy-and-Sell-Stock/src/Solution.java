class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int curMax = 0, max = 0;
        for (int i = 1; i < prices.length; i++) {
            curMax = Math.max(0, curMax + prices[i] - prices[i - 1]);
            max = Math.max(max, curMax);
        }
        return max;
    }
}