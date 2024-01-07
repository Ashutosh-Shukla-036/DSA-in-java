import java.util.Scanner;

public class LinkedList{
    static class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int length;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Boolean insert(int value , int index){
        Node newNode = new Node(value);
        if(index < 0 || index > length){
            return false;
        }else if(length == 0){
            head = newNode;
            tail = newNode;
        }else if(index == 0){
            newNode.next = head;
            head = newNode;
        }else{
            Node temp = head;
            for(int i=0 ; i < index-1 ; i++){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        length++;
        return true;
    }

    public int search(int target){
        Node temp = head;
        int index = 0;
        while(temp != null){
            if(temp.value == target){
                return index;
            }
            temp = temp.next;
            index += 1;
        }
        return -1;
    }

    public int pop() {
        if (length == 0) {
            return -1;
        }
    
        int poppedItem = tail.value;
        if (length == 1) {
            head = tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
        length--;
        return poppedItem;
    }
    

    public String toString(){
        StringBuilder result = new StringBuilder();
        Node temp = head;
        while(temp != null){
            result.append(temp.value);
            if(temp.next != null){
                result.append("->");
            }
            temp = temp.next;
        }
        return result.toString();
    }
    

    public static void main(String[]args){
        LinkedList l = new LinkedList();
        int opt;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("--------------------------------------------\n");
            System.out.print("Enter 1 for Append element in LinkedList\n");
            System.out.print("Enter 2 for Prepend element in LinkedList\n");
            System.out.print("Enter 3 for insert element in LinkedList\n");
            System.out.print("Enter 4 to display the LinkedList\n");
            System.out.print("Enter 5 to search a element in LinkedList\n");
            System.out.print("Enter 6 for poping element from LinkedList\n");
            System.out.print("Enter 7 for exiting LinkedList application...\n");
            System.out.print("Enter choice:");
            opt = sc.nextInt();

            switch(opt){
                case 1:
                    System.out.print("Enter element to append:");
                    int ele = sc.nextInt();
                    l.append(ele);
                    break;
                case 2:
                    System.out.print("Enter element to prepend:");
                    int ele1 = sc.nextInt();
                    l.prepend(ele1);
                    break;
                case 3:
                    System.out.print("Enter element to insert and index:");
                    int ele2 = sc.nextInt();
                    int index = sc.nextInt();
                    l.insert(ele2, index);
                    break;
                    case 4:
                    System.out.println("Displaying LinkedList: " + l.toString());
                    break;                
                case 5:
                    System.out.print("Enter element to search:");
                    int target = sc.nextInt();
                    System.out.println("Element at index:"+l.search(target));
                    break;
                case 6:
                    System.out.println("poped item:"+l.pop());
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Input...");
                    break;
            }

        }while(opt != 7);
        sc.close();
    }
}
