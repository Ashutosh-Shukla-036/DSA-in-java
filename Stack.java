import java.util.Scanner;

public class Stack {
    public int size = 5;
    private int[] stack = new int[size];
    public int top = -1 ;

    void Push(int item){
        if(top == size-1){
            System.out.println("Stack is full");
        }else{
            stack[++top] = item;
        }
    }

    int Pop(){
        if(top == -1){
            System.out.println("Stack is empty");
            return -1;
        }else{
            return stack[top--];
        }
    }

    void display(){
        System.out.println("Stack Content:");
        for(int i=top ; i>=0 ; i--){
            System.out.println(stack[i]+" ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args){
        Stack s = new Stack();
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
                    s.Push(item);
                    break;
                case 2:
                    System.out.println("Poped item is:"+s.Pop());
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

