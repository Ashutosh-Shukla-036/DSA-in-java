import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input dimensions of matrices
        System.out.print("Enter the number of rows for matrix A: ");
        int m = scanner.nextInt();
        System.out.print("Enter the number of columns for matrix A (and rows for matrix B): ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of columns for matrix B: ");
        int p = scanner.nextInt();

        // Input elements of matrix A
        System.out.println("Enter elements of matrix A:");
        int[][] A = inputMatrix(m, n, scanner);

        // Input elements of matrix B
        System.out.println("Enter elements of matrix B:");
        int[][] B = inputMatrix(n, p, scanner);

        // Perform matrix multiplication
        int[][] result = matrixMultiply(A, B);

        // Display the result
        System.out.println("Result after multiplication:");
        printMatrix(result);

        scanner.close();
    }

    static int[][] inputMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    static int[][] matrixMultiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;

        int[][] result = new int[m][p];

        // Initialize the result matrix to zeros
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                result[i][j] = 0;
            }
        }

        // Perform matrix multiplication
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }

    static void printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}