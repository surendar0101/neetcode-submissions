class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int result = right;
        while (left <= right) {
            int k = left + (right - left) / 2;
            int total = 0;
            for (int p: piles) {
                total += Math.ceil((double) p / k);
            }
            if (total <= h) {
                result = k;
                right = k - 1;
            } else {
                left = k + 1;
            }
        }
        return result;
    }
}
