import java.util.Scanner;

public class Queue {
    public int front = 0;
    public int rear = 0;
    public int count = 0;
    public int size = 5;
    private int[] q = new int[size];

    void enqueue(int item){
        if(count == size-1){
            System.out.println("Queue is full");
        }else{
            rear = (rear+1) % size;
            q[rear] = item;
            count++;
        }
    }

    int dequeue(){
        if(front == rear && count == 0){
            System.out.println("Queue is empty");
            return -1;
        }else{
            front = (front+1)%size;
            count--;
            return q[front];
        }
    }

    void display(){
        System.out.println("Queue Content:");
        for(int i=(front+1)%size ; i!=(rear+1)%size ; i=(i+1)%size){
            System.out.println(q[i]+" ");
        }
        System.err.println(" ");
    }

    public static void main(String[] args){
        Queue q = new Queue();
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
                    q.enqueue(item);
                    break;
                case 2:
                    System.out.println("Dequeued item is:"+q.dequeue());
                    break;
                case 3:
                    q.display();
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
