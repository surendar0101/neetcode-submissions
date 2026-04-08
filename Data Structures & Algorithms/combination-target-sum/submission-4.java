class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, curr, 0, nums, target);
        return result;
    }

    private void dfs(int i, List<Integer> curr, int total, int[] nums, int target) {
        if (total == target) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (total + nums[j] > target)
                return;
            curr.add(nums[j]);            
            dfs(j, curr, total + nums[j], nums, target);
            curr.remove(curr.size() - 1);
        }
    }
}
