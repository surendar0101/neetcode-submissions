class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void dfs(int i, int[] candidates, int total, int target, List<Integer> curr) {
        if (total == target) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if ( j > i && candidates[j] == candidates[j-1])
                continue;
            
            if (total + candidates[j] > target)
                break;

            curr.add(candidates[j]);
            dfs( j + 1, candidates, total + candidates[j], target, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
