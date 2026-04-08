class Solution {
    private int ROWS, COLS;
    private int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    dfs(grid, r, c, visited);
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int r, int c, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] == 0 || visited[r][c])
            return 0;
        visited[r][c] = true; // Mark as visited

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int maxArea = 1;
        for (int[] dir: directions) {
            maxArea += dfs(grid, r + dir[0], c + dir[1], visited);
        }
        max = Math.max(max, maxArea);
        return maxArea;
    } 
}
