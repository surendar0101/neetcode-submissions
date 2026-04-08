class Solution {
    Map<Integer, List<Integer>> preReqMap = new HashMap<>();
    Set<Integer> visitSet = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        for (int course = 0; course < numCourses ; course++) {
            preReqMap.put(course, new ArrayList<>());
        }

        // create adjacency list for prerequisites
        for (int[] pair: prerequisites) {
            preReqMap.get(pair[0]).add(pair[1]);
        }

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course) {
        if (visitSet.contains(course)) {
            return false;
        }

        if (preReqMap.get(course).isEmpty()) {
            return true;
        }

        visitSet.add(course);
        for(int pre: preReqMap.get(course)) {
            if (!dfs(pre)) {
                return false;
            }
        }
        visitSet.remove(course);
        preReqMap.put(course, new ArrayList<>());
        return true;
    }
}
