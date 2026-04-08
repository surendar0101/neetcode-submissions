class Solution {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        // if n == 1 then a single element forms a graph, but check if edges are present
        if (n==1) return edges.length == 0;

        // if n > 1, and edges are not present then they can't form a tree
        if (edges.length == 0) return false;

        // create an adjacency list using bidirection edges
        for (int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adjList.putIfAbsent(node1, new ArrayList<>());
            adjList.putIfAbsent(node2, new ArrayList<>());
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }

        if (!dfs(edges[0][0], -1)) {
            return false;
        }
        return visited.size() == n;
    }

    // pass current node and prev to eliminate false positive loops
    private boolean dfs(int node, int prev) {
        if (visited.contains(node)) return false;

        visited.add(node);
        for(int neighbour: adjList.get(node)) {
            if (neighbour == prev) continue; // this is a false positive case hence continue

            if (!dfs(neighbour, node)) {
                return false;
            }
        }
        return true;
    }
}
