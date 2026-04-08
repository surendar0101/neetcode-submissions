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
            // If target is zero them we've found a combination
            result.add(new ArrayList<>(cur));
        } else if (target < 0 || index >= nums.length) {
            // we've hit the base case extremes so break
            return;
        } else {
            // add nums[index] to cur list
            cur.add(nums[index]);
            // update the target with target - nums[index]
            backTrack(nums, target - nums[index], result, cur, index);
            
            // pop the last element
            cur.remove(cur.get(cur.size() - 1));

            // proceed with next branch / combination
            backTrack(nums, target, result, cur, index + 1);
        }
    }
}
