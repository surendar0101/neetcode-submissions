class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0, sell = 0, profit = 0;
        int n = prices.length;

        while(sell < n) {
            if (prices[sell] > prices[buy]) {
                profit = Math.max(profit, prices[sell]-prices[buy]);
            } else {
                buy = sell;
            }
            sell++;
        }
        return profit;
    }
}
