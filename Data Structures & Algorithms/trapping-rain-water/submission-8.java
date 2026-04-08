class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        int left = 0, right = n-1;
        int maxLeft = height[left], maxRight = height[right];
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
