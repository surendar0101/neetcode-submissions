class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0)
            return new int[][] {newInterval};
        
        int n = intervals.length;
        int left = 0, right = n - 1;
        int target = newInterval[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < left; i++)
            result.add(intervals[i]);
        
        result.add(newInterval);

        for (int i = left; i < n; i++)
            result.add(intervals[i]);
        
        // Merge intervals
        List<int[]> merged = new ArrayList<>();
        for (int[] interval: result) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0])
                merged.add(interval);
            else
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
        }
        return merged.toArray(new int[0][]);
    }
}
