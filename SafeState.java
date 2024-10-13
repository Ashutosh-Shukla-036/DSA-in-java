/*
There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed
 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge 
 from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting 
from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
 */

import java.util.ArrayList;

public class SafeState {

    private boolean DFS(int node, boolean[] visited, boolean[] pathVisited, boolean[] isSafe, int[][] graph) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                if (DFS(neighbor, visited, pathVisited, isSafe, graph)) {
                    return true;
                }
            } else if (pathVisited[neighbor]) {
                return true;
            }
        }

        pathVisited[node] = false;
        isSafe[node] = true;
        return false;
    }
   
    public ArrayList<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        boolean[] isSafe =  new boolean[n];
        ArrayList<Integer> result = new ArrayList<>();

        for (int i=0 ; i<n ; i++) {
            if (!visited[i]) {
                DFS(i,visited,pathVisited,isSafe,graph);
            }
        }

        for (int i=0 ; i<n ; i++) {
            if (isSafe[i]) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SafeState safeState = new SafeState();
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        ArrayList<Integer> safeNodes = safeState.eventualSafeNodes(graph);
        System.out.println(safeNodes);
    }
}
