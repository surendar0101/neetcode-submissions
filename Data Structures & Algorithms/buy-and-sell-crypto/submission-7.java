class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0, sell = 0, profit = 0, n = prices.length;
        while(sell < n) {
            if (prices[buy] < prices[sell]) {
                profit = Math.max(profit, prices[sell] - prices[buy]);
            } else {
                buy = sell;
            }
            sell++;
        }
        return profit;
    }
}
