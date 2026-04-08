/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int prevEnd = Integer.MIN_VALUE;
        for(Interval interval: intervals) {
            int start = interval.start;
            int end = interval.end;
            if (prevEnd > start) 
                return false;
            prevEnd = end;
        }
        return true;
    }
}
