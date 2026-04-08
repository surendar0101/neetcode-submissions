class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort the given intervals as per start time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();

        // Add the first interval to the list to start with
        result.add(intervals[0]);
        for(int[] interval: intervals) {
            int start = interval[0];
            int end = interval[1];
            // Get the last end
            int lastEnd = result.get(result.size()-1)[1];

            if (start <= lastEnd) {
                // if the start is less than or equal to lastEnd
                // then there could be a chance of overlap
                // update the max of end with last interval
                result.get(result.size() - 1)[1] = Math.max(end, lastEnd);
            } else {
                // else simply add the interval to result
                result.add(interval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
