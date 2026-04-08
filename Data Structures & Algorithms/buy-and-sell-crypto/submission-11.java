class Solution {
    public int maxProfit(int[] prices) {
        int finalProfit = 0;
        int sell = 0, buy = 0;
        while(sell < prices.length) {
            if (prices[buy] < prices[sell]) {
                finalProfit = Math.max(finalProfit, prices[sell] - prices[buy]);
            } else {
                buy = sell;
            }
            sell++;
        }
        return finalProfit;
    }
}
