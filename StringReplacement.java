import java.util.Scanner;

public class StringReplacement {
    static String str, pat, rep;
    static StringBuilder ans;
    static int i, j, k, n, m;
    static int flag = 0;

    static void stringMatch() {
        i = j = n = m = 0;
        ans = new StringBuilder();

        while (i < str.length()) {
            if (str.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
                if (j == pat.length()) {
                    flag = 1;
                    ans.append(rep);
                    j = 0;
                }
            } else {
                ans.append(str.charAt(i));
                i++;
                m++;
                n = i;
                j = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter main string: ");
        str = scanner.nextLine();
        System.out.print("Enter pattern string: ");
        pat = scanner.nextLine();
        System.out.print("Enter replace string: ");
        rep = scanner.nextLine();

        stringMatch();

        if (flag == 1) {
            System.out.println("String successfully changed: " + ans.toString());
        } else {
            System.out.println("Pattern not found.");
        }
        scanner.close();
    }
}
