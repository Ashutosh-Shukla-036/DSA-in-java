/*
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the 
graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Pair {
    int node;
    int color;

    public Pair(int node, int color) {
        this.node = node;
        this.color = color;
    }
}

public class BipartiteGraph {

    private boolean BFS(int node, int[][] graph, int[] visited, Queue<Pair> queue, int color) {
        visited[node] = color;
        queue.add(new Pair(node,color));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int Node = current.node;
            int Color = current.color;

            for (int neighbor : graph[Node]) {
                if (visited[neighbor] == -1) {
                    visited[neighbor] = 1 - Color;
                    queue.add(new Pair(neighbor, visited[neighbor]));
                } else {
                    if (visited[neighbor] == Color) {
                        return false;
                    }
                }
            }
        }
        return true;
    } 

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        Queue<Pair> queue = new LinkedList<>();
        int[] visited = new int[n];
        Arrays.fill(visited,-1);

        for (int i=0 ; i<n ; i++) {
            if (visited[i] == -1) {
                if (!BFS(i,graph,visited,queue,0)) {
                    return false;
                } 
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BipartiteGraph obj = new BipartiteGraph();

        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};

        System.out.println(obj.isBipartite(graph));
    }
}
