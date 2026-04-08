class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backTrack(nums, target, result, cur, 0);
        return result;
    }

    private void backTrack(
        int[] nums,
        int target,
        List<List<Integer>> result,
        List<Integer> cur,
        int index
    ) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
        } else if (target < 0 || index >= nums.length) {
            return;
        } else {
            cur.add(nums[index]);
            backTrack(nums, target - nums[index], result, cur, index);

            cur.remove(cur.get(cur.size() - 1));
            backTrack(nums, target, result, cur, index + 1);
        }
    }
}
