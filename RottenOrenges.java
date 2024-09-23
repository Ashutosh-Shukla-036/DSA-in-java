/* 
You are given a 2D grid where:
0: Empty cell.
1: Fresh orange.
2: Rotten orange.

Every minute, fresh oranges adjacent (up, down, left, right) to a rotten orange will rot. The task is to find the 
minimum time for all fresh oranges to rot. If some fresh oranges can't rot, return -1.

Solution Explanation:
Step 1: Initialize a queue with all rotten oranges and count the fresh oranges.
Step 2: Use Breadth-First Search (BFS) to simulate rotting. For each rotten orange, infect all adjacent fresh 
        oranges, and keep track of the time it takes.
Step 3: After BFS, if all fresh oranges have rotted, return the time. Otherwise, return -1 (if some fresh 
        oranges are isolated).

Why BFS and Not DFS?
BFS explores level by level, which models the simultaneous spreading of rot. This ensures we get the minimum time for each fresh orange to rot.
DFS explores in one direction fully before moving to others, which doesn't suit this problem where simultaneous rotting is key.

 */

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int col;
    int time;

    public Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class RottenOrenges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        int currentFresh = 0;

        // Step 1: Initialize the grid and queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                }

                if (grid[i][j] == 1) {
                    currentFresh += 1;
                }
            }
        }

        int totalTime = 0;
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};
        int count = 0;

        // Step 2: Process the rotting process
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int row = current.row;
            int col = current.col;
            int time = current.time;
            totalTime = Math.max(totalTime, time);

            for (int i = 0; i < 4; i++) {
                int newRow = row + deltaRow[i];
                int newCol = col + deltaCol[i];
                if ((newRow >= 0 && newRow < n) && (newCol >= 0 && newCol < m) && 
                    (visited[newRow][newCol] != 2) && (grid[newRow][newCol] == 1)) {
                    queue.add(new Pair(newRow, newCol, time + 1));
                    visited[newRow][newCol] = 2;
                    count += 1;
                }
            }
        }

        // Step 3: Check if all fresh oranges have rotted
        if (currentFresh != count) {
            return -1;
        }
        return totalTime;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        RottenOrenges orenges = new RottenOrenges();
        System.out.println(orenges.orangesRotting(grid));
    }
}
