class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int finalArea = 0;
        while(left < right) {
            int currArea = (right - left) * Math.min(heights[left], heights[right]);
            finalArea = Math.max(currArea, finalArea);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return finalArea;
    }
}
