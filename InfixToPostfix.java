import java.util.Scanner;

public class InfixToPostfix {
    static int top = -1;
    static char[] stack = new char[20];
    
    static void push(char ele) {
        if (top == 19) {
            System.out.println("Stack is full");
        } else {
            stack[++top] = ele;
        }
    }

    static char pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return '\0'; // return a placeholder value
        } else {
            return stack[top--];
        }
    }

    static int priority(char c) {
        if (c == '#')
            return 0;
        else if (c == '(')
            return 1;
        else if (c == '+' || c == '-')
            return 2;
        else if (c == '/' || c == '*' || c == '%')
            return 3;
        else if (c == '^' || c == '$')
            return 4;
        else
            return 5;
    }

    public static void main(String[] args) {
        char[] infix = new char[20];
        char[] postfix = new char[20];
        int i = 0, j = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter infix expression:");
        String input = scanner.next();
        infix = input.toCharArray();

        push('#');
        while (i < infix.length) {
            if (Character.isLetterOrDigit(infix[i])) {
                postfix[j++] = infix[i];
            } else if (infix[i] == '(') {
                push(infix[i]);
            } else if (infix[i] == ')') {
                while (stack[top] != '(') {
                    postfix[j++] = pop();
                }
                top--;
            } else {
                while (top != -1 && priority(stack[top]) >= priority(infix[i])) {
                    postfix[j++] = pop();
                }
                push(infix[i]);
            }
            i++;
        }

        while (stack[top] != '#') {
            postfix[j++] = pop();
        }
        postfix[j++] = '\0';

        System.out.println("Postfix expression is: " + new String(postfix));
        scanner.close();
    }
}

