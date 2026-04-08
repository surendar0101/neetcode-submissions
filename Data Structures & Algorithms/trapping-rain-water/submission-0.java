class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int result = 0;
        int leftMaxHeight = height[left], rightMaxHeight = height[right];
        while(left < right) {
            if (leftMaxHeight < rightMaxHeight) {
                left++;
                leftMaxHeight = Math.max(height[left], leftMaxHeight);
                result += leftMaxHeight - height[left];
            } else {
                right--;
                rightMaxHeight = Math.max(rightMaxHeight, height[right]);
                result += rightMaxHeight - height[right];
            }
        }
        return result;
    }
}
