class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0, sell = 1, maxProfit = 0, n = prices.length;
        while(sell < n) {
            if (prices[sell] > prices[buy]) {
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            } else {
                buy = sell;
            }
            sell++;
        }
        return maxProfit;
    }
}
