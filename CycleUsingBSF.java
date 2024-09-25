import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Pair {
    int node;
    int parentNode;
    
    public Pair(int node, int parentNode) {
        this.node = node;
        this.parentNode = parentNode;
    }
}

public class CycleUsingBSF {
    
    private boolean Detect(int node,ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Pair> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(new Pair(node,-1));
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int Node = current.node;
            int ParentNode = current.parentNode;
            
            for (int neighbor : adj.get(Node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new Pair(neighbor,Node));
                } else if (visited[neighbor]) {
                    if (ParentNode != neighbor) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V+1];
        
        for (int i=0 ; i<V ; i++) {
            if (!visited[i]) {
                if (Detect(i,adj,visited)) {
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
        
        CycleUsingBSF obj = new CycleUsingBSF();
        boolean result = obj.isCycle(V, adj);
        
        if (result) {
            System.out.println("Cycle detected.");
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
