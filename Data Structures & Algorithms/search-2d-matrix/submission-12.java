class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int left = 0, right = ROWS * COLS - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / COLS;
            int col = mid % COLS;
            if (target == matrix[row][col])
                return true;
            else if (matrix[row][col] < target)
                left++;
            else 
                right--;
        }
        return false;
    }
}
