public class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0)
                    q.add(new int[] {r, c});
            }
        }

        // If no tresure found, then no point in proceeding further
        if (q.size() == 0)
            return;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0], col = node[1];
            for (int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r >= m || r < 0 || c >= n || c < 0 || grid[r][c] != Integer.MAX_VALUE)
                    continue;
                q.add(new int[] {r, c});

                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}