/*
In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that 
cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

1)Every time you are located in a cell you will collect all the gold in that cell.
2)From your position, you can walk one step to the left, right, up, or down.
3)You can't visit the same cell more than once.
4)Never visit a cell with 0 gold.
5)You can start and stop collecting gold from any position in the grid that has some gold.

The intuition behind solving the maximum gold collection problem is using backtracking and depth-first search (DFS) which 
revolves around exploring all possible paths in the grid where gold can be collected while adhering to specific 
movement and collection constraints
 */


public class PathWithMaxGold {

    private int DFS(int[][] grid, int row, int col) {
        int n = grid.length;
        int m = grid[0].length;
        int collectedGold = grid[row][col];
        grid[row][col] = 0;

        int[] deltaRow = {-1,0,1,0};
        int[] deltaCol = {0,1,0,-1};
        int goldHere = 0;

        for (int i=0 ; i<4 ; i++) {
            int newRow = row + deltaRow[i];
            int newCol = col + deltaCol[i];

            if (newRow >= 0 && newRow < n && newCol >=0 && newCol < m && grid[newRow][newCol] != 0) {
                goldHere = Math.max(goldHere,DFS(grid, newRow, newCol));
            }
        }

        grid[row][col] = collectedGold;

        return collectedGold + goldHere;
    }

    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxGold = 0;

        for (int i=0 ; i<n ; i++) {
            for (int j=0 ; j<m ; j++) {
                maxGold = Math.max(maxGold,DFS(grid,i,j));
            }
        }
        return maxGold;
    }

    public static void main(String[] args) {

        PathWithMaxGold gm = new PathWithMaxGold();

        int[][] goldMine = {
            {0, 6, 0},
            {5, 8, 7},
            {0, 9, 0}
        };
        
        System.err.println(gm.getMaximumGold(goldMine));
    }
}
