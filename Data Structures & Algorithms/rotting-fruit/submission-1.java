class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> q = new ArrayDeque<>();
        int ROWS = grid.length, COLS = grid[0].length;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1)
                    fresh++;
                if (grid[r][c] == 2)
                    q.add(new int[] { r, c});
            }
        }
        int time = 0;
        // Right, left, down, up
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while (fresh > 0 && !q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] curr = q.poll();
                int row = curr[0], col = curr[1];
                for (int[] dir: directions) {
                    int r = row + dir[0], c = col + dir[1];
                    if (r >= 0 && r < ROWS && c >=0 && c < COLS && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.offer(new int[]{r,c});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
