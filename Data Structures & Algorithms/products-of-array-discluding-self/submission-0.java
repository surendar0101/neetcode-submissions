class Solution {
    public int[] productExceptSelf(int[] nums) {
        int postFix = 1;
        int n = nums.length;
        int[] answer = new int[n];
        for(int i=0; i < n; i++) {
            answer[i] = postFix;
            postFix *= nums[i];
        }
        postFix = 1;
        for(int i = n-1; i >= 0; i--) {
            answer[i] *= postFix;
            postFix *= nums[i];
        }
        return answer;
    }
}  
