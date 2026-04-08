class Solution {
    private int ROWS, COLS;
    public int orangesRotting(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        int freshOranges = 0;
        Queue<int[]> rottenQueue = new LinkedList<>();
        for (int r=0; r<ROWS; r++) {
            for (int c=0; c<COLS; c++) {
                if (grid[r][c] == 1)
                    freshOranges++;
                if (grid[r][c] == 2)
                    rottenQueue.add(new int[] {r,c});
            }
        }

        int timeTaken = 0;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (freshOranges > 0 && !rottenQueue.isEmpty()) {
            int size = rottenQueue.size();
            for (int i=0; i<size; i++) {
                int[] point = rottenQueue.poll();
                for (int[] dir: directions) {
                    int r = point[0] + dir[0];
                    int c = point[1] + dir[1];
                    if (r >= 0 && c >=0 && r < ROWS && c < COLS && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        freshOranges--;
                        rottenQueue.add(new int[] {r,c});
                    }
                }
            }
            timeTaken++;
        }
        return freshOranges == 0 ? timeTaken : -1;
    }
}
