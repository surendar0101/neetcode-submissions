class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int result = 0;
        while (left < right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            if (maxLeft <= maxRight) {
                result += maxLeft - height[left];
                left++;
            } else {
                result += maxRight - height[right];
                right--;
            }
        }
        return result;
    }
}
