class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // Minimum possible eating rate
        int right = Arrays.stream(piles).max().getAsInt();
        int result = right; // This is the max possible rate
        while (left <= right) {
            int k = left + (right - left) / 2;
            int totalTime = 0;
            for (int pile: piles)
                totalTime += Math.ceil((double) pile/k);
            if (totalTime <= h) {
                result = k;
                right = k - 1;
            } else {
                left = k + 1;
            }
        }
        return result;
    }
}
