class Solution {
    public boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;
        int wordIndex = 0;

        for (int r=0; r<ROWS; r++) {
            for (int c=0; c<COLS; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (dfs(board, word, wordIndex, r, c, ROWS, COLS)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int r, int c, int ROWS, int COLS) {
        if(r < 0 || r >= ROWS || c < 0 || c >= COLS ||
            board[r][c] != word.charAt(index)) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        board[r][c] = '#'; // marking as visited
        if (dfs(board, word, index + 1, r + 1, c, ROWS, COLS) ||
            dfs(board, word, index + 1, r - 1, c, ROWS, COLS) ||
            dfs(board, word, index + 1, r, c + 1, ROWS, COLS) ||
            dfs(board, word, index + 1, r, c - 1, ROWS, COLS)) {
                return true;
        }
        board[r][c] = word.charAt(index); // in order to back track again in other path
        return false;
    }
}
