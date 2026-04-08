class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for(int[] interval: intervals) {
            if(null == newInterval || interval[1] < newInterval[0]) {
                // if new interval already merged 
                // or if end of current interval is lt newInterval start
                // add it to result
                result.add(interval);
            } else if(interval[0] > newInterval[1]) {
                // if start of current interval > end of newInterval
                // add new interval first and then current interval
                // and make newInterval null
                result.add(newInterval);
                result.add(interval);
                newInterval = null;
            } else {
                // seems like there is a overlap
                // update the new interval with current interval
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        if(null != newInterval) {
            result.add(newInterval);
        }
        return result.toArray(new int[result.size()][]);
    }
}
