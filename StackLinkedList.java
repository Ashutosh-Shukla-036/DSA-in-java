import java.util.Scanner;

public class StackLinkedList {

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    Node top = null;

    void push(int value) {
        Node newNode = new Node(value);
        if(top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    int pop() {
        if(top == null) {
            return -1;
        } else {
            int deleteitem = top.value;
            Node deleteNode = top;
            top = deleteNode.next;
            return deleteitem;
        }
    }

    void display() {
        System.out.println("Stack Content:");
        for(Node i=top ; i != null ; i=i.next) {
            System.out.println(i.value);
        }
        System.out.println();
    }

    public static void main(String[] args){
        StackLinkedList s = new StackLinkedList();
        int opt;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("--------------------------\n");
            System.out.print("Enter 1 for Push\nEnter 2 for Pop\nEnter 3 for Display\nEnter 4 for Exiting\nEnter Choice:");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    System.out.print("Enter item to Push:");
                    int item = sc.nextInt();
                    s.push(item);
                    break;
                case 2:
                    int popele = s.pop();
                    if (popele == -1) {
                        System.out.println("Stack is empty");
                    } else {
                        System.out.println("Poped item is:"+popele);
                    }
                    break;
                case 3:
                    s.display();
                    break;
                case 4:
                    System.out.println("Exiting Queue....");
                    break;
                default:
                    System.out.println("Invalid Input..");
                    break;
            }
        }while(opt != 4);
        sc.close();
    }
}