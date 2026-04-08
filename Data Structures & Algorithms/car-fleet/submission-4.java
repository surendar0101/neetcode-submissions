class Pair {
    private int position;
    private int speed;
    public Pair(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }
}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Pair[] pairs = new Pair[n];
        for (int i=0; i<n; i++)
            pairs[i] = new Pair(position[i], speed[i]);
        
        Arrays.sort(pairs, (a,b) -> b.position - a.position);

        int fleets = 0;
        double lastTime = 0;
        for (int i=0; i<n; i++) {
            // Time = distance / speed
            double currTime = (double) (target - pairs[i].position) / pairs[i].speed;
            if (currTime > lastTime) {
                fleets++;
                lastTime = currTime;
            }
        }
        return fleets;
    }
}
