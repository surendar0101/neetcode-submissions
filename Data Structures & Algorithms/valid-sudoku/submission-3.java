class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                if (board[r][c] == '.')
                    continue;
                
                String sqKey = r/3 + "," + c/3;
                if (
                    rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) || 
                    cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) || 
                    squares.computeIfAbsent(sqKey, k -> new HashSet<>()).contains(board[r][c])
                )
                    return false;
                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(sqKey).add(board[r][c]);
            }
        }

        return true;
    }
}
