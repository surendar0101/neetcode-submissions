class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int steps = 0;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int INF = 2147483647;
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 0)
                    q.add(new int[] {r,c});
            }
        }

        if (q.isEmpty())
            return;

        while (!q.isEmpty()) {
            steps++;
            int size = q.size();
            for (int i=0; i<size; i++) {
                int[] node = q.poll();
                int row = node[0];
                int col = node[1];
                for (int[] dir: directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if (nr >= ROWS || nr < 0 || nc >= COLS || nc < 0 || grid[nr][nc] != INF)
                        continue;
                    q.add(new int[] {nr, nc});

                    grid[nr][nc] = grid[row][col] + 1;
                }
            }
        }
    }
}
