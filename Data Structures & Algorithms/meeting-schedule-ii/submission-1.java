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
    public int minMeetingRooms(List<Interval> intervals) {
        int len = intervals.size();
        if(len == 0) return 0;
        int[] startTime = new int[len];
        int[] endTime = new int[len];
        
        for(int i=0; i<len; i++) {
            startTime[i] = intervals.get(i).start;
            endTime[i] = intervals.get(i).end;
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int count = 0;
        int result = 0;
        int s = 0, e = 0;

        while(s < len) {
            if (startTime[s] < endTime[e]) {
                count++;
                s++;
            } else {
                e++;
                count--;
            }
            result = Math.max(result, count);
        }

        return result;
    }
}
