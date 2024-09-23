/*
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 
4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.
 */

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class MaxAreaOfIsland {

    private int BFS(int i, int j, int[][] grid, boolean[][] visited, Queue<Pair> queue, int[] deltaRow, int[] deltaCol) {
        visited[i][j] = true;
        queue.add(new Pair(i,j));
        int count = 1;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int row = current.row;
            int col = current.col;

            for (int k=0 ; k<4 ; k++) {
                int newRow = row + deltaRow[k];
                int newCol = col + deltaCol[k];

                if ((newRow >= 0 && newRow < grid.length) && (newCol >= 0 && newCol < grid[0].length) && (grid[newRow][newCol] == 1) && (!visited[newRow][newCol])) {
                    visited[newRow][newCol] = true;
                    queue.add(new Pair(newRow,newCol));
                    count++;
                }
            }
        }
        return count;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<>();
        int MaxCount = 0;
        int[] deltaRow = {-1,0,1,0};
        int[] deltaCol = {0,1,0,-1}; 


        for (int i=0 ; i<n ; i++) {
            for (int j=0 ; j<m ; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int currentIsLandSize = BFS(i,j,grid,visited,queue,deltaRow,deltaCol);
                    MaxCount = Math.max(MaxCount,currentIsLandSize);
                }
            }
        }
        return MaxCount;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland area = new MaxAreaOfIsland();
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(area.maxAreaOfIsland(grid));
    }
}
