class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int result = right;
        while (left <= right) {
            int k = left + (right - left) / 2;
            long totalHours = 0;
            for (int pile: piles)
                totalHours += Math.ceil((double) pile / k);
            if (totalHours <= h) {
                result = k;
                right = k - 1;
            } else {
                left = k + 1;
            }
        }
        return result;
    }
}
