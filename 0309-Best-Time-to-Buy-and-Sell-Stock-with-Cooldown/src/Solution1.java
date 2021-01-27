class Solution1 {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int rest = 0, sold = 0, hold = Integer.MIN_VALUE;
        for (int price : prices) {
            int preSold = sold;
            hold = Math.max(hold, rest - price);
            rest = Math.max(rest, preSold);
            sold = hold + price;
        }
        return Math.max(rest, sold);
    }
}