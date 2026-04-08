class Solution {
    
    Map<Integer, List<Integer>> preReqMap = new HashMap<>();
    Set<Integer> visitSet = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int course = 0; course < numCourses; course++) {
            preReqMap.put(course, new ArrayList<>());
        }

        for (int[] pair: prerequisites) {
            preReqMap.get(pair[0]).add(pair[1]);
        }

        for (int course = 0 ; course < numCourses; course++) {
            if (!dfs(course)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int crs) {
        if (visitSet.contains(crs)) {
            return false;
        }

        if (preReqMap.get(crs).isEmpty()) {
            return true;
        }

        visitSet.add(crs);
        for(int pre: preReqMap.get(crs)) {
            if (!dfs(pre)) {
                return false;
            }
        }
        visitSet.remove(crs);
        preReqMap.put(crs, new ArrayList<>());
        return true;
    }
}
