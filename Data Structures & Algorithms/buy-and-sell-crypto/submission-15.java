class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int buy = 0, sell = 0;
        while (sell < prices.length) {
            if (prices[sell] > prices[buy]) {
                result = Math.max(result, prices[sell] - prices[buy]);
            } else {
                buy = sell;
            }
            sell++;
        }
        return result;
    }
}
