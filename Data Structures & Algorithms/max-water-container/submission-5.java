class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left =0, right = n-1;
        int area = 0;
        while(left < right) {
            int currectArea = Math.min(heights[left], heights[right]) * (right - left);
            area = Math.max(currectArea, area);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
