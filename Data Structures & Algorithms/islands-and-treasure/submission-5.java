class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        // Capture the indices of treasure
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r< ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 0)
                    q.add(new int[] {r,c});
            }
        }
        // If no treasure found no point in proceeding further
        if (q.isEmpty()) return;

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                int row = node[0], col = node[1];
                for (int[] dir: directions) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] != Integer.MAX_VALUE) 
                        continue;
                    q.add(new int[] {r,c});
                    grid[r][c] = grid[row][col] + 1;
                }
            }
        }
    }
}
