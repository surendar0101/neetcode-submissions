class Solution {
    // By negating elements in each index
    public int findDuplicate(int[] nums) {
        for(int num: nums) {
            int index = Math.abs(num);
            if (nums[index] < 0)
                return index;
            nums[index] *= -1;  
        }
        return -1;
    }
}
