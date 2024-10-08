import java.util.*;

class Solution {
    private boolean dfsCheck(int node, List<List<Integer>> adj, int[] vis, int[] pathVis) {
        vis[node] = 1;
        pathVis[node] = 1;

        // Traverse for adjacent nodes
        for (int it : adj.get(node)) {
            // When the node is not visited
            if (vis[it] == 0) {
                if (dfsCheck(it, adj, vis, pathVis)) {
                    return true;
                }
            }
            // If the node has been previously visited
            // but it has to be visited on the same path
            else if (pathVis[it] == 1) {
                return true;
            }
        }

        pathVis[node] = 0;
        return false;
    }

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, List<List<Integer>> adj) {
        int[] vis = new int[V];
        int[] pathVis = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfsCheck(i, adj, vis, pathVis)) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class CycleInDirectedGraph {
    public static void main(String[] args) {
        // V = 11, E = 11;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        int V = 11;
        Solution obj = new Solution();
        boolean ans = obj.isCyclic(V, adj);

        if (ans)
            System.out.println("True");
        else
            System.out.println("False");
    }
}
