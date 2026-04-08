class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(0, nums, 0, target, new ArrayList<>());
        return result;
    }

    private void dfs(int i, int[] nums, int total, int target, List<Integer> curr) {
        if (total == target) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for (int j = i; j < nums.length; j++) {
            if (total + nums[j] > target)
                return;
            curr.add(nums[j]);
            dfs(j, nums, total + nums[j], target, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
