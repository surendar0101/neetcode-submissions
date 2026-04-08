class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0, right = n-1;
        int result = 0;
        while(left < right) {
            int currArea = Math.min(heights[left], heights[right]) * (right - left);
            result = Math.max(currArea, result);
            if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
