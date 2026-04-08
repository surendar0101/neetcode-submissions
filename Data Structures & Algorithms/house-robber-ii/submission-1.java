class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        return Math.max(
            nums[0], // This is to handle only one house in street
            Math.max(
                robHelper(Arrays.copyOfRange(nums, 0, n-1)), // check the max from start to last but one element
                robHelper(Arrays.copyOfRange(nums, 1, n)) // check the max from next to start to last element
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
