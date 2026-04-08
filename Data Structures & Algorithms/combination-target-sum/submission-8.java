class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(0, nums, 0, target, new ArrayList<>());
        return result;
    }

    private void dfs(int i, int[] nums, int total, int target, List<Integer> curr) {
        if (target == total) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for (int j=i; j<nums.length; j++) {
            if (target < total)
                return;
            curr.add(nums[j]);
            dfs(j, nums, total + nums[j], target, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
