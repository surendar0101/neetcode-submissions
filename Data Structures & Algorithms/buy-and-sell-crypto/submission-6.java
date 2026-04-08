class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0, sell = 0, maxProfit = 0;
        int n = prices.length;
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
