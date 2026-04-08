class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for (int i=0; i<position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        // Sort the pairs in decreasing order of position (reverse order)
        Arrays.sort(pair, (a,b) -> Integer.compare(b[0], a[0]));

        double lastTime = 0.0; 
        int fleet = 0;
        for (int[] p: pair) {
            double currentTime = (double) (target - p[0]) / p[1];
            if (currentTime > lastTime) {
                lastTime = currentTime;
                fleet++;
            }
        }
        return fleet;
    }
}
