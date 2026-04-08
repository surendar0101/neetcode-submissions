class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pairs = new int[n][2];
        for (int i=0; i<n; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        // Sort desc based on position
        Arrays.sort(pairs, (a,b) -> b[0] - a[0]);
        int fleets = 0;
        double lastTime = 0;
        for (int[] pair: pairs) {
            // time = distance / speed
            double currTime = (double) (target - pair[0])/ pair[1];
            if (currTime > lastTime) {
                fleets++;
                lastTime = currTime;
            }            
        }
        return fleets;
    }
}
