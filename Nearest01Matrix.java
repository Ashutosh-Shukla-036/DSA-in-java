/*
Given a binary grid of n*m. Find the distance of the nearest 1 in the grid for each cell.
The distance is calculated as |i1  - i2| + |j1 - j2|, where i1, j1 are the row number and column number of the
current cell, and i2, j2 are the row number and column number of the nearest cell having value 1. There should be 
atleast one 1 in the grid
 */

import java.util.Queue;
import java.util.LinkedList;

class Node {
    int row;
    int col;
    int distance;

    // Constructor for the Node class to store coordinates and distance
    public Node(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

public class Nearest01Matrix {
    
    // Function to find distance of nearest 1 in the grid for each cell
    public int[][] nearest(int[][] grid) {
        int n = grid.length;         // Number of rows
        int m = grid[0].length;      // Number of columns
        boolean[][] visited = new boolean[n][m];  // To keep track of visited cells
        Queue<Node> queue = new LinkedList<>();   // BFS Queue to store the cells to be processed
        int[][] result = new int[n][m];           // Resultant matrix to store distances

        // Add all the cells with '1' to the queue as the starting points of BFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new Node(i, j, 0));   // Add all 1s to the queue with distance 0
                    visited[i][j] = true;          // Mark these cells as visited
                }
            }
        }

        // Possible 4 directions for moving in the grid: up, right, down, left
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        // BFS traversal to calculate shortest distances
        while (!queue.isEmpty()) {
            Node current = queue.poll();  // Remove the front node from the queue
            int row = current.row;
            int col = current.col;
            int distance = current.distance;

            // Update the result matrix with the distance for the current cell
            result[row][col] = distance;

            // Traverse in all 4 possible directions
            for (int i = 0; i < 4; i++) {
                int newRow = row + deltaRow[i];
                int newCol = col + deltaCol[i];

                // Check if the new cell is within bounds and not visited
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol]) {
                    queue.add(new Node(newRow, newCol, distance + 1));  // Add new cell with incremented distance
                    visited[newRow][newCol] = true;  // Mark new cell as visited
                }
            }
        }
        return result;
    }

    // Helper function to print the 2D matrix in a readable format
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Test input grid
        int[][] grid = {
            {0, 1, 0, 0},
            {1, 0, 0, 0},
            {0, 0, 1, 0}
        };

        Nearest01Matrix obj = new Nearest01Matrix();
        int[][] result = obj.nearest(grid);

        // Printing the result matrix
        System.out.println("Distance of nearest 1 for each cell:");
        printMatrix(result);
    }
}
