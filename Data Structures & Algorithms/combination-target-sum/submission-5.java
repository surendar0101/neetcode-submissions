class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, new ArrayList<>(), 0, nums, target, result);
        return result;
    }

    private void dfs(int i, List<Integer> curr, int total, int[] nums, int target, List<List<Integer>> result) {
        if (total == target) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (total + nums[j] > target)
                return;
            curr.add(nums[j]);            
            dfs(j, curr, total + nums[j], nums, target, result);
            curr.remove(curr.size() - 1);
        }
    }
}
