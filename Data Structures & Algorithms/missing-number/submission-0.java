class Solution {
    public int missingNumber(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int num: nums) count += num;
        return  (n * (n+1) / 2) - count;
    }
}
