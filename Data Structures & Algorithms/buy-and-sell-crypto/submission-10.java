class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0, sell = 0;
        int profit = 0;
        while(sell < prices.length) {
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
