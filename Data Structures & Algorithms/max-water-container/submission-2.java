class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int maximumArea = 0;
        while(left < right) {
            int currentArea = (right - left) * Math.min(heights[left], heights[right]);
            maximumArea = Math.max(maximumArea, currentArea);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maximumArea;
    }
}
