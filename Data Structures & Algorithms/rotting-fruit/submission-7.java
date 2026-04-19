class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        // Capture the following
        // 1) total fresh oranges count 
        // 2) indices of rotten oranges
        for (int r=0; r<ROWS; r++) {
            for (int c=0; c<COLS; c++) {
                if (grid[r][c] == 1)
                    fresh++;
                if (grid[r][c] == 2)
                    q.add(new int[] {r,c});
            }
        }

        int time = 0;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (fresh != 0 && !q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int[] point = q.poll();
                int row = point[0];
                int col = point[1];
                for (int[] dir: directions) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (r >= 0 && c >= 0 && r < ROWS && c < COLS && grid[r][c] == 1) {
                        fresh--;
                        q.add(new int[] {r,c});
                        grid[r][c] = -1;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
