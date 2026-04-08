class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));

        List<int[]> result = new ArrayList<>();
        for(int[] interval: intervals) {
            if (result.size() == 0 || result.get(result.size() - 1)[1] < interval[0]) 
                result.add(interval);
            else
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
        }
        return result.toArray(new int[result.size()][]);
    }
}
