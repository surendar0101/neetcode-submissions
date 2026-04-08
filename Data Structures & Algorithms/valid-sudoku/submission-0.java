class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] columns = new int[9];
        int[] box = new int[9];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int bitMask = 1 << (num - 1);
                    int boxIndex = (i/3) * 3 + (j / 3);
                    if ((rows[i] & bitMask) != 0 || 
                        (columns[j] & bitMask) != 0 || 
                        (box[boxIndex] & bitMask) != 0) {
                        return false;
                    }
                    rows[i] |= bitMask;
                    columns[j] |= bitMask;
                    box[boxIndex] |= bitMask;
                }
            }
        }
        return true;
    }
}
