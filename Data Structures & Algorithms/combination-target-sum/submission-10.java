class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.result = new ArrayList<>();
        dfs(0, nums, 0, target, new ArrayList<>());
        return this.result;
    }

    private void dfs(int i, int[] nums, int total, int target, List<Integer> curr) {
        if (total == target) {
            this.result.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (total < target) {
                curr.add(nums[j]);
                dfs(j, nums, total + nums[j], target, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
