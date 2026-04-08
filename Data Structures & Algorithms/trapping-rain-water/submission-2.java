class Solution {
    public int trap(int[] height) {
        int result = 0;
        int left = 0, right = height.length-1;
        int maxLeft = height[left], maxRight = height[right];
        while(left < right) {
            if (maxLeft < maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                result = result + maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                result = result + maxRight - height[right];
            }
        }
        return result;
    }
}
