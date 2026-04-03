class Solution {
    private int ROWS, COLS;
    public int numIslands(char[][] grid) {
        int result = 0;
        ROWS = grid.length;
        COLS = grid[0].length;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    dfs(r, c, grid);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, char[][] grid) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || grid[r][c] == '0')
            return;
        
        grid[r][c] = '0'; // Mark as visited
        dfs(r + 1, c, grid); // down
        dfs(r - 1, c, grid); // top
        dfs(r, c + 1, grid); // right
        dfs(r, c - 1, grid); // left
    }
}
