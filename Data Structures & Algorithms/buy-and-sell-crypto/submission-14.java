class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int buy = 0, sell = 0;
        while (sell < prices.length) {
            int currProfit = prices[sell] - prices[buy];
            if (prices[sell] > prices[buy]) {
                result = Math.max(result, currProfit);
            } else {
                buy = sell;
            }
            sell++;
        }
        return result;
    }
}
