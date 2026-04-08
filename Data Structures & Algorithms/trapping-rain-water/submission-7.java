class Solution {
    public int trap(int[] height) {
        int result = 0;
        int n = height.length;
        int left = 0, right = n - 1;
        int maxLeft = height[0], maxRight = height[n-1];
        while (left < right) {
            if (maxLeft <= maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                result += maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                result += maxRight - height[right];
            }
        }
        return result;
    }
}
