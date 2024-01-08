import java.util.Scanner;

public class StringReplacement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter main String:");
        String mainString = scanner.nextLine();
        System.out.print("Enter pattern String:");
        String patternString = scanner.nextLine();
        System.out.print("Enter replace String:");
        String replaceString = scanner.nextLine();

        scanner.close();

        String resultString = stringMatch(mainString, patternString, replaceString);

        if (resultString != null) {
            System.out.println("The resultant String is: " + resultString);
        } else {
            System.out.println("Pattern not found...");
        }
    }

    public static String stringMatch(String mainString, String patternString, String replaceString) {
        StringBuilder resultString = new StringBuilder();
        int i = 0, n = 0;
        boolean flag = false;

        while (i < mainString.length()) {
            if (mainString.charAt(i) == patternString.charAt(n)) {
                i++;
                n++;
                if (n == patternString.length()) {
                    flag = true;
                    resultString.append(replaceString);
                    n = 0;
                }
            } else {
                resultString.append(mainString.charAt(i));
                i++;
                n = 0;
            }
        }
        return flag ? resultString.toString() : null;
    }
}
