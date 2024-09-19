import java.util.*;

public class DepthFirstSearch {

    public static void DFS(int node , ArrayList<ArrayList<Integer>> adj , boolean[] visited , ArrayList<Integer> result) {
        visited[node] = true;
        result.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                DFS(neighbor, adj, visited,result);
            }
        }
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj , int u , int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void main(String[] args) {
        int n = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i=0 ; i<=n ; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 5);
        addEdge(adj, 2, 6);
        addEdge(adj, 3, 4);
        addEdge(adj, 3, 7);
        addEdge(adj, 4, 8);
        addEdge(adj, 8, 7);

        for (int i=1 ; i<=n ; i++) {
            System.out.print("Node " + i + ": ");
            for (int j=0 ; j<adj.get(i).size() ; j++) {
                System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println();
        }

        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> result = new ArrayList<>();
        DFS(3, adj, visited, result);
        System.out.println("DFS Traversal starting from node " + 3 + ": " + result);

    }
}
