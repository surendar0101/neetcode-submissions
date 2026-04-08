class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int buy = 0, sell = 0;
        while(sell < prices.length) {
            int currProf = prices[sell] - prices[buy];
            if (prices[sell] > prices[buy]) {
                result = Math.max(result, currProf);
            } else {
                buy = sell;
            }
            sell++;
        }
        return result;
    }
}
