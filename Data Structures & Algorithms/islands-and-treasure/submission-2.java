public class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int INF = 2147483647;
    private int ROWS, COLS;

    private int dfs(int[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        boolean[][] visited = new boolean[ROWS][COLS];
        visited[r][c] = true;
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int row = curr[0], col = curr[1];
                if (grid[row][col] == 0)
                    return steps;

                for (int[] dir : directions) {
                    int nr = row + dir[0], nc = col + dir[1];
                    if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && grid[nr][nc] != -1
                        && !visited[nr][nc]) {
                            visited[nr][nc] = true;
                            q.add(new int[]{nr,nc});
                        }
                }
            }
            steps++;
        }
        return INF;
    }

    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == INF) {
                    grid[r][c] = dfs(grid, r, c);
                }
            }
        }
    }
}