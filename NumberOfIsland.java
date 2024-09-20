import java.util.Queue;
import java.util.LinkedList;

class Pair{
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class NumberOfIsland {

    private static void BFS(int row , int col , char[][] grid , boolean[][] visited) {
        visited[row][col] = true;
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(row, col));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int Row = current.first;
            int Col = current.second;

            for (int i=-1 ; i<=1 ; i++) {
                for (int j=-1 ; j<=1 ; j++) {
                    if (Math.abs(i) == Math.abs(j)) {
                        continue;
                    }
                    int newRow = Row + i;
                    int newCol = Col + j;

                    if ((newRow >= 0 && newRow < n) && (newCol >=0 && newCol < m) && 
                    (grid[newRow][newCol] == '1') && (!visited[newRow][newCol])) {
                        visited[newRow][newCol] = true;
                        queue.add(new Pair(newRow,newCol));
                    }
                }
            }
        }
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (!visited[row][col] && grid[row][col] == '1') {
                    count++;
                    BFS(row,col,grid,visited);
                }
            }
            
        }
        return count;
    }
    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '1', '0'},
            {'0', '0', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '1'}
        };

        System.out.println(numIslands(grid));
    }
    
}
