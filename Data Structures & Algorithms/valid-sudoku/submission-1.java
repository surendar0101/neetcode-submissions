class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] columns = new int[9];
        int[] box = new int[9];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++) {
                // If the character is not '.' only then perform the business logic
                if(board[i][j] != '.') {
                    // Convert the char number into an integer
                    int num = board[i][j] - '0';
                    // bitwise masked number, eg: for 4 the array will be 000001000
                    int bitMask = 1 << (num - 1);
                    int boxIndex = (i/3) * 3 + (j / 3);
                    // Check row-wise, column-wise and box-wise
                    if ((rows[i] & bitMask) != 0 || 
                        (columns[j] & bitMask) != 0 || 
                        (box[boxIndex] & bitMask) != 0) {
                        return false;
                    }
                    // Set the numbers in rows, columns and box.
                    rows[i] |= bitMask;
                    columns[j] |= bitMask;
                    box[boxIndex] |= bitMask;
                }
            }
        }
        return true;
    }
}
