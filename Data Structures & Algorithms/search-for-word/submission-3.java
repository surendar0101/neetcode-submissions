class Solution {
    int ROWS, COLS;
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        int index = 0;

        for(int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (dfs(r, c, index, board, word)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    private boolean dfs(int r, int c, int index, char[][] board, String word) {
        if (r < 0 || r >= ROWS ||
            c < 0 || c >= COLS ||
            board[r][c] != word.charAt(index)) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        board[r][c] = '#';
        if (dfs(r + 1, c, index + 1, board, word) || 
            dfs(r - 1, c, index + 1, board, word) || 
            dfs(r, c + 1, index + 1, board, word) || 
            dfs(r, c - 1, index + 1, board, word)) {
                return true;
        }
        board[r][c] = word.charAt(index);
        return false;
    }
}
