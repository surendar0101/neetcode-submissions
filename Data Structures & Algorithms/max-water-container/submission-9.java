class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0, right = n - 1;
        int result = 0;
        while( left < right) {
            int currArea = (right - left) * Math.min(heights[left], heights[right]);
            result = Math.max(result, currArea);
            if (heights[left] < heights[right])
                left++;
            else
                right--;
        }
        return result;
    }
}
