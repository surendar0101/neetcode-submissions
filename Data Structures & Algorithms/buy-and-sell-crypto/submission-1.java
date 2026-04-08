class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, right = 1, maxProfit = 0, n = prices.length;
        while(right < n) {
            if (prices[left] < prices[right]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }
}
