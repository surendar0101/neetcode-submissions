class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length -1;
        for(int i=nums.length-1; i>=0; i--) {
            if (lastPos <= i + nums[i]) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
