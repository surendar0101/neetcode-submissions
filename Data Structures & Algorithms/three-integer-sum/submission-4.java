class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            // Since the array is sorted, if current element if > 0
            // then all the upcoming elements are > 0 so we can break loop
            if (nums[i] > 0) break;

            // Skipping duplicates
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int j = i+1, k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    // If sum is zero store the indices as a list
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    k--;
                    
                    // Skip duplicates from the right
                    while(j < k && nums[k] == nums[k+1]) {
                        k--;
                    }
                } else if (sum > 0) {
                    // shift the right pointer
                    k--;
                } else {
                    // shift the left pointer
                    j++;
                }
            }
        }
        return result;
    }
}
