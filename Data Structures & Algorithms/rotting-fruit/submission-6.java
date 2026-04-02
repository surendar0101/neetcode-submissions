class Solution {
    private int ROWS, COLS;
    public int orangesRotting(int[][] grid) {
        this.ROWS = grid.length;
        this.COLS = grid[0].length;

        int fresh = 0;
        Queue<int[]> rotten = new LinkedList<>();
        int totalTime = 0;
        for (int r=0; r<ROWS; r++) {
            for (int c=0; c<COLS; c++) {
                if (grid[r][c] == 1)
                    fresh++;
                if (grid[r][c] == 2)
                    rotten.add(new int[] {r,c});
            }
        }

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (fresh > 0 && !rotten.isEmpty()) {
            int size = rotten.size();
            for (int i=0; i<size; i++) {
                int[] point = rotten.poll();
                int row = point[0], col = point[1];
                for (int[] dir: directions) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (r >= 0 && r < ROWS && c >= 0 && c < COLS && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        rotten.add(new int[]{r, c});
                        fresh--;
                    }
                }
            }
            totalTime++;
        }
        return fresh == 0 ? totalTime : -1;
    }
}
