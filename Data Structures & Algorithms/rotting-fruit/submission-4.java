class Solution {
    private int ROWS, COLS;
    public int orangesRotting(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1)
                    fresh++;
                if (grid[r][c] == 2)
                    q.add(new int[] { r, c});
            }
        }

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int time = 0;
        while (fresh > 0 && !q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int[] points = q.poll();
                int row = points[0], col = points[1];
                for (int[] dir: directions) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (r >= 0 && c >= 0 && r < ROWS && c < COLS && grid[r][c] == 1) {
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
