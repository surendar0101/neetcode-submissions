class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxElement = getMaxElement(piles);
        int left = 1, right = maxElement;
        int result = right;
        while (left <= right) {
            int k = left + (right - left)/2;
            long totalTime = 0;
            for (int p: piles)
                totalTime += Math.ceil((double) p / k);
            if (totalTime <= h) {
                result = k;
                right = k - 1;
            }
            else {
                left = k + 1;
            }
        }
        return result;
    }

    private int getMaxElement(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int pile: piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}
