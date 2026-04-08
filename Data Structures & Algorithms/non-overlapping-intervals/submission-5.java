class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1)
            return 0;
        // Sort intervals based on ascending order of end time
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        
        int result = 0;
        int currEnd = Integer.MIN_VALUE;

        for (int[] interval: intervals) {
            int start = interval[0];
            int end = interval[1];
            if (start >= currEnd) {
                result++;
                currEnd = end;
            }
        }
        return intervals.length - result;
    }
}
