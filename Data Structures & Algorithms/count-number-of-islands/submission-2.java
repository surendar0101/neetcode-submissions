class Solution {
    private int ROWS, COLS;
    public int numIslands(char[][] grid) {
        int count = 0;
        ROWS = grid.length;
        COLS = grid[0].length;
        for (int r=0; r<ROWS; r++) {
            for (int c=0; c<COLS; c++) {
                if (grid[r][c] != '0') {
                    dfs(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || grid[r][c] == '0')
            return;
        grid[r][c] = '0'; // Mark Visited
        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
    }
}
