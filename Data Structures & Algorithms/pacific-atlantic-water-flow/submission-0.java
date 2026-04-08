class Solution {
    private Set<String> pacific = new HashSet<>(); 
    private Set<String> atlantic = new HashSet<>();
    private int ROW, COL;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        ROW = heights.length;
        COL = heights[0].length;

        // perform dfs for first column to check if all elements can reach pacific ocean
        for(int c = 0; c < COL; c++) {
            // passing current height as the prevHeight considering the condition prevHeight <= currHeight can hold true
            dfs(0, c, pacific, heights[0][c], heights);
            dfs(ROW - 1, c, atlantic, heights[ROW - 1][c], heights);
        }

        // perform dfs for last column to check if all elements can reach atlantic ocean
        for(int r = 0; r < ROW; r++) {
            dfs(r, 0, pacific, heights[r][0], heights);
            dfs(r, COL - 1, atlantic, heights[r][COL - 1], heights);
        }

        for(int r=0; r<ROW; r++) {
            for(int c=0; c<COL; c++) {
                if (pacific.contains(String.valueOf(r + "," + c)) && atlantic.contains(String.valueOf(r + "," + c))) {
                    result.add(List.of(r,c));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, Set<String> visit, int prevHeight, int[][] heights) {

        if (r < 0 || r >= ROW || c < 0 || c >= COL ||
            prevHeight > heights[r][c] || visit.contains(String.valueOf(r + "," + c))) 
            return;
        
        visit.add(r + "," + c);
        dfs(r + 1, c, visit, heights[r][c], heights);
        dfs(r - 1, c, visit, heights[r][c], heights);
        dfs(r, c + 1, visit, heights[r][c], heights);
        dfs(r, c - 1, visit, heights[r][c], heights);
    }
}
