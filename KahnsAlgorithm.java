import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class KahnsAlgorithm {

    private ArrayList<Integer> TopoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int indegree[] = new int[V];
        for (int i=0 ; i<V ; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        for (int i=0 ; i<V ; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                } 
            }
        }
        return result;
    }
    public static void main(String[] args) {
        KahnsAlgorithm obj = new KahnsAlgorithm();

        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // Example graph: 5 -> 0, 5 -> 2, 4 -> 0, 4 -> 1, 2 -> 3, 3 -> 1
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);


        ArrayList<Integer> topoArray = obj.TopoSort(V,adj);
        System.out.println("Topological Sort of the given graph:");
        for (int node : topoArray) {
            System.out.print(node + " ");
        }
    }
}
