class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        return Math.max(
            nums[0], 
            Math.max(
                robHelper(Arrays.copyOfRange(nums, 0, n-1)), 
                robHelper(Arrays.copyOfRange(nums, 1, n))
                )
            );
    }

    public int robHelper(int[] nums) {
        int rob1 = 0, rob2 = 0;
        for(int value: nums) {
            int temp = Math.max(value + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
