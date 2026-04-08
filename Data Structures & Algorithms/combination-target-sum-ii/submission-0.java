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

        if (total > target || i == candidates.length) return;

        curr.add(candidates[i]);
        dfs( i + 1, candidates, total + candidates[i], target, curr);
        curr.remove(curr.size() - 1);

        while (i + 1 < candidates.length && candidates[i] == candidates[i+1])
            i++;
        
        dfs(i+1, candidates, total, target, curr);
    }
}
