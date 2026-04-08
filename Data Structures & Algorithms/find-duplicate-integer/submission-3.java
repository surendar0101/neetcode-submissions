class Solution {
    // By negating elements in each index
    public int findDuplicate(int[] nums) {
        for(int num: nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0)
                return Math.abs(num);
            nums[index] *= -1;  
        }
        return -1;
    }
}
