import java.util.ArrayList;

public class CycleUsingDFS {
    
    private boolean DFS(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (DFS(neighbor, node, adj, visited)) {
                    return true;
                }
            } else {
                if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V+1];

        for (int i=0 ; i<V ; i++) {
            if (!visited[i]) {
                if (DFS(i,-1,adj,visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        // Initialize the adjacency list with empty lists for each vertex.
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        // Add edges to the adjacency list (undirected graph)
        adj.get(0).add(1);
        
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(4);
        
        adj.get(2).add(1);
        adj.get(2).add(3);
        
        adj.get(3).add(2);
        adj.get(3).add(4);
        
        adj.get(4).add(1);
        adj.get(4).add(3);
        
        CycleUsingDFS obj = new CycleUsingDFS();
        boolean result = obj.isCycle(V, adj);
        
        if (result) {
            System.out.println("Cycle detected.");
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
