class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0, sell = 0, maxProfit = 0;
        int n = prices.length;
        while(sell < n) {
            // If selling price is > bought price then
            if (prices[sell] > prices[buy]) {
                // Calculate profit
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            } else {
                // update buy to sell and change the window
                 buy = sell;
            }
            sell++;
        }
        return maxProfit;
    }
}
