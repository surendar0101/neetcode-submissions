class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0, ROWS = grid.length, COLS = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        // 1. Calculate total fresh oranges
        // 2. Push positions of rotten oranges to start BFS
        for (int r = 0; r<ROWS; r++) {
            for (int c = 0; c<COLS; c++) {
                if (grid[r][c] == 1)
                    fresh++;
                if (grid[r][c] == 2)
                    q.add(new int[]{r,c});
            }
        }

        int time = 0; // Keeps track of total time taken for rotting all oranges
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while (fresh > 0 && !q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int[] curr = q.poll();
                for (int[] dir: directions) {
                    int r = dir[0] + curr[0], c = dir[1] + curr[1];
                    // if the r, c within range and current orange not rotten, mark for rotten and reduce fresh count
                    // Add the newly rotten orange position in queue
                    if (r >= 0 && r < ROWS && c >=0 && c < COLS && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.add(new int[] {r,c});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
