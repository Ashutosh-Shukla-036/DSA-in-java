import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BreathFirstSearch {

    public static void BFS(ArrayList<ArrayList<Integer>> adj , int start) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visit = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();

        visit[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            int node = queue.remove();
            result.add(node); 

            for (int neighbor : adj.get(node)) {
                if (!visit[neighbor]) {
                    queue.add(neighbor);
                    visit[neighbor] = true;
                }
            }
        }

        System.out.println("BFS Traversal starting from node " + start + ": " + result);

    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj , int u , int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void main(String[] args) {
        int n = 9;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i=0 ; i<= n ; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 1, 2);
        addEdge(adj, 1, 6);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 8);
        addEdge(adj, 6, 9);
        addEdge(adj, 6, 7);
        addEdge(adj, 7, 8);

        for (int i=1 ; i<=n ; i++) {
            System.out.print("Node " + i + ": ");
            for (int j=0 ; j<adj.get(i).size() ; j++) {
                System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println();
        }

        BFS(adj, 1);
    }
}