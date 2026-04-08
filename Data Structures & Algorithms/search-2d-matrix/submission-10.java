class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROW = matrix.length, COL = matrix[0].length;
        int left = 0, right = ROW * COL - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / COL;
            int col = mid % COL;
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] < target)
                left = mid + 1;
            else 
                right = mid - 1;
        }
        return false;
    }
}
