class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        int time = 0;

        // Calculate fresh oranges and identify position of rotten oranges
        for (int r=0; r<ROWS; r++) {
            for (int c=0; c<COLS; c++) {
                if (grid[r][c] == 1)
                    fresh++;
                if (grid[r][c] == 2)
                    q.add(new int[] {r,c});
            }
        }

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (fresh > 0 && !q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int[] point = q.poll();
                int row = point[0], col = point[1];
                for (int[] dir: directions) {
                    int r = dir[0] + row;
                    int c = dir[1] + col;
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
