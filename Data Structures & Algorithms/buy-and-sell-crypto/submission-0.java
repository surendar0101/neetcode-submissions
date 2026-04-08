class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minSoFar = Integer.MAX_VALUE;
        for(int num: prices) {
            minSoFar = Math.min(num , minSoFar);
            maxProfit = Math.max(maxProfit, num - minSoFar);
        }
        return maxProfit;
    }
}
