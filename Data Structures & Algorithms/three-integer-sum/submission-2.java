class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // if nums[i] is greater than 0 then all the 
            // following numbers numbers are greater than 0 and sum != 0
            if (nums[i] > 0) break;
            // Skipping duplicates from the front
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int j= i+1, k = nums.length -1;
            while( j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    k--;
                    // Skipping duplicates from the end
                    while(j < k && nums[k] == nums[k+1]) {
                        k--;
                    }
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}
