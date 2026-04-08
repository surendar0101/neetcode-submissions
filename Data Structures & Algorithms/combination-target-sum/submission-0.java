class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backTrack(nums, target, result, curr, 0);
        return result;
    }

    private void backTrack(
        int[] nums, 
        int target,
        List<List<Integer>> result,
        List<Integer> curr,
        int index
    ) {

        if ( target == 0) {
            result.add(new ArrayList<>(curr));
        } else if (target < 0 || index >= nums.length ) {
            return;
        } else {
            curr.add(nums[index]);
            backTrack(nums, target - nums[index], result, curr, index);

            curr.remove(curr.get(curr.size() - 1));
            backTrack(nums, target, result, curr, index + 1);
        }
    }
}
