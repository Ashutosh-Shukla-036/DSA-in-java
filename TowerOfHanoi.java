import java.util.Scanner;

public class TowerOfHanoi {

    private static int stepCount = 0;

    public static void tower(int n, char source, char auxiliary, char destination) {
        if (n == 0) {
            return;
        }

        tower(n - 1, source, destination, auxiliary);
        System.out.println("Move disc " + n + " from " + source + " to " + destination);
        stepCount++;
        tower(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of discs: ");
        int n = scanner.nextInt();

        if (n > 0) {
            tower(n, 'A', 'B', 'C');
            System.out.println("Total number of steps: " + stepCount);
        } else {
            System.out.println("Number of discs should be greater than 0.");
        }

        scanner.close();
    }
}
