class Solution {
    public int rob(int[] nums) {
        int rob1=0, rob2=0;
        // [rob1, rob2, n, n+1,.....]
        for (int value: nums) {
            int temp = Math.max(value + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
