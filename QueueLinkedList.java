import java.util.Scanner;

public class QueueLinkedList {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    Node front;
    Node rear;
    int length;

    void enqueue(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        length++;
    }

    int dequeue() {
        if (length == 0) {
            return -1;
        }
        int popitem = front.value;
        if(length == 1) {
            front = rear = null;
        } else {
            front = front.next;
        }
        length--;
        return popitem;
    }

    void display() {
        System.out.println("Queue Content:");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println(" ");
    }

    public static void main(String[] args){
        QueueLinkedList s = new QueueLinkedList();
        int opt;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("--------------------------\n");
            System.out.print("Enter 1 for Enqueue\nEnter 2 for Dequeue\nEnter 3 for Display\nEnter 4 for Exiting\nEnter Choice:");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    System.out.print("Enter item to enqueue:");
                    int item = sc.nextInt();
                    s.enqueue(item);
                    break;
                case 2:
                    int popele = s.dequeue();
                    if (popele == -1) {
                        System.out.println("Queue is empty");
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
