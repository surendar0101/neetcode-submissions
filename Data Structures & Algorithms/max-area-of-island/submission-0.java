class Solution {
    private int max = 0;
    private int ROWS, COLS;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null)
            return 0;
        ROWS = grid.length;
        COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        for (int r=0; r<ROWS; r++) {
            for (int c=0; c<COLS; c++) {
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
        
        visited[r][c] = true;
        int area = 1;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for (int[] dir: directions) {
            int row = dir[0] + r;
            int col = dir[1] + c;
            area += dfs(grid, row, col, visited);
        }
        max = Math.max(max, area);
        return area;
    }
}
