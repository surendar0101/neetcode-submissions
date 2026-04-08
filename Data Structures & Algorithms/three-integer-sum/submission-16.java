class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i=0; i<n; i++) {

            // No possible combinations to form a triplet with sum 0
            if (nums[i] > 0)
                break;

            // Skip duplicates from left
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0)
                    k--;
                else if (sum < 0)
                    j++;
                else {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    k--;
                    // Skip duplicates from right
                    while (k > j && nums[k] == nums[k+1]) 
                        k--;
                }
            }
        }
        return result;
    }
}