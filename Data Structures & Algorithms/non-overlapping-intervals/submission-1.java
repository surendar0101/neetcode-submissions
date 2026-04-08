class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int prevEnd = intervals[0][1];
        int result = 0;
        for(int i=1; i<intervals.length; i++) {
            // holds the start of current interval
            int start = intervals[i][0]; 
            
            // holds the end of current interval
            int end = intervals[i][1];

            /* If start of current interval is 
            * greater than or equal to end of previous interval
            * then no overlap found
            * else there is an overlap
            */
            if (start >= prevEnd) {
                prevEnd = end;
            } else {
                result++;
                prevEnd = Math.min(prevEnd, end);
            }
        }
        return result;
    }
}
