class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for (int[] interval: intervals) {
            if (newInterval == null || interval[1] < newInterval[0])
                result.add(interval);
            else if (interval[0] > newInterval[1]) {
                // No interval to be merged
                result.add(newInterval);
                result.add(interval);
                newInterval = null;
            } else {
                // Merge the current interval with new interval
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        // If all the intervals are merged
        if (newInterval != null)
            result.add(newInterval);
        return result.toArray(new int[0][]);
    }
}
