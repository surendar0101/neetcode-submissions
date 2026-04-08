class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int[] result = new int[n];
        
        // In first run first element in result array will always be 1
        result[0] = 1;

        // In the current index store the product of prefix elements
        // This will happen from left to right of array
        for(int i = 1; i<n; i++) {
            result[i] = nums[i-1] * result[i-1];
        }

        // Now calculate the product of postfix elements
        // This will happen from right to left of array
        int postfix = 1;
        for(int i=n-1; i>=0; i--) {
            result[i] = result[i] * postfix;
            postfix = postfix * nums[i];
        }
        return result;
    }
}  
