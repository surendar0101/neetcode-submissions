class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<n; i++) {
            if (nums[i] > 0)
                break;
            
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            int j = i + 1, k = n - 1;
            while ( j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                result.add(List.of(nums[i], nums[j], nums[k]));
                k--;
                while ( j < k && nums[k] == nums[k+1])
                    k--;
                } else if (sum < 0) 
                    j++;
                else 
                    k--;
            }
        }
        return result;
    }
}
