class Solution {
    private int[] parent;
    private int[] rank;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        for (int i=0; i< n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int result = n;

        for(int[] edge: edges) {
            result -= union(edge[0], edge[1]);
        }
        return result;
    }

    // find the super parent of the given node
    private int find(int node) {
        int result = node;
        
        // stop if the result is parent of itself
        while(result != parent[result]) {
            parent[result] = parent[parent[result]];
            result = parent[result];
        }
        return result;
    }


    private int union(int node1, int node2) {
        int p1 = find(node1);
        int p2 = find(node2);

        if (p1 == p2) return 0;

        if (rank[p1] < rank[p2]) {
            parent[p1] = p2;
            rank[p1] += rank[p2];
        } else {
            parent[p2] = p1;
            rank[p2] += rank[p1];
        }
        return 1;
    }
}
