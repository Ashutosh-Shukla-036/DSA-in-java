import java.util.Scanner;

public class Polynomial {
    static class Node{
        float coeff;
        int exp;
        Node next;

        public Node(float coeff , int exp){
            this.coeff = coeff;
            this.exp = exp;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int length;

    public Polynomial(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    void append(float coeff, int exp) {
        Node newNode = new Node(coeff, exp);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;

    }
    

    public String toString(){
        StringBuilder result = new StringBuilder();
        Node temp = head;
        while(temp != null){
            result.append("("+temp.coeff+")");
            result.append("X^");
            result.append(temp.exp);
            if(temp.next != null){
                result.append(" + ");
            }
            temp = temp.next;
        }
        return result.toString();
    }

    public static Polynomial add(Polynomial a, Polynomial b) {
        Node A = a.head;
        Node B = b.head;
        Polynomial c = new Polynomial();
    
        while (A != null && B != null) {
            if (A.exp == B.exp) {
                c.append(A.coeff + B.coeff, A.exp);
                A = A.next;
                B = B.next;
            } else if (A.exp > B.exp) {
                c.append(A.coeff, A.exp);
                A = A.next;
            } else {
                c.append(B.coeff, B.exp);
                B = B.next;
            }
        }
        while (A != null) {
            c.append(A.coeff, A.exp);
            A = A.next;
        }
        while (B != null) {
            c.append(B.coeff, B.exp);
            B = B.next;
        }
        c.combineTerms();
    
        return c;
    }
    private void combineTerms() {
        Node current = head;
    
        while (current != null) {
            Node runner = current.next;
            while (runner != null) {
                if (current.exp == runner.exp) {
                    current.coeff += runner.coeff;
                    deleteNode(runner);
                    runner = current.next; 
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
    
    private void deleteNode(Node nodeToDelete) {
        Node current = head;
    
        if (current == nodeToDelete) {
            head = current.next;
            if (head == null) {
                tail = null;
            }
            length--;
            return;
        }
    
        while (current != null && current.next != nodeToDelete) {
            current = current.next;
        }
    
        if (current != null) {
            current.next = nodeToDelete.next;
            if (current.next == null) {
                tail = current;
            }
            length--;
        }
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Polynomial a = new Polynomial();
        Polynomial b = new Polynomial();
    
        System.out.print("Enter the length of Polynomial A:");
        int n = sc.nextInt();
        System.out.println("Enter Polynomial A");
        for (int i = 0; i < n; i++) {
            System.out.println("--------------------\n");
            System.out.print("Enter coefficient:");
            float coeff = sc.nextFloat();
            System.out.print("Enter exponent:");
            int exp = sc.nextInt();
            a.append(coeff, exp);
        }
        System.out.println("-----------------------------\n");
        System.out.print("Enter the length of Polynomial B:");
        int n1 = sc.nextInt();
        System.out.println("Enter Polynomial B");
        for (int i = 0; i < n1; i++) {
            System.out.println("---------------------\n");
            System.out.print("Enter coefficient:");
            float coeff = sc.nextFloat();
            System.out.print("Enter exponent:");
            int exp = sc.nextInt();
            b.append(coeff, exp);
        }
        System.out.println("------------------------------\n");
    
        System.out.println("Polynomial A: " + a.toString());
        System.out.println("Polynomial B: " + b.toString());

        Polynomial result = Polynomial.add(a, b);
        System.out.println("Polynomial A + B: " + result.toString());


        sc.close();
    }
    
}
