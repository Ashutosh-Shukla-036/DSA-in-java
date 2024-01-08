import java.util.Scanner;

public class CSLinkedList {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int length;
    
    public CSLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        length++;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        Node temp = head;
        while(temp != null) {
            result.append(temp.value);
            temp = temp.next;
            result.append("->");
            if(temp == head) {
                break;
            }
        }
        return result.toString();
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        length++;
    }

    public Boolean insert(int value , int index) {
        Node newNode = new Node(value);
        if(index < 0 || index > length) {
            return false;
        } else if(index == 0) {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        } else {
            Node temp = head;
            for(int i=0 ; i<index-1 ; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        length++;
        return true;
    }

    public int search(int target) {
        Node temp = head;
        int index = 0;
        while(temp != null) {
            if(temp.value == target) {
                return index;
            }
            temp = temp.next;
            index++;
            if(temp == head) {
                break;
            }
        }
        return -1;
    }

    public int pop() {
        if(length == 0) {
            return -1;
        }
        int popitem = tail.value;
        if(length == 1) {
            head = tail = null;
        } else {
            Node temp = head;
            while(temp.next != tail) {
                temp = temp.next;
            }
            tail.next = null;
            tail = temp;
            tail.next = head;
        }
        length--;
        return popitem;
    }

    public int fpop() {
        if(length == 0) {
            return -1;
        }
        int popitem = head.value;
        if(length == 1) {
            head = tail = null;
        } else {
            Node temp = head;
            head = temp.next;
            tail.next = head;
        }
        length--;
        return popitem;
    }

    public Boolean DeleteLinkedList() {
        if(length == 0) {
            return false;
        }
        if(length == 1) {
            head = tail = null;
        } else {
            Node current = head;
            Node nextNode;
            while(current != tail) {
                nextNode = current.next;
                current.next = null;
                current = nextNode;
            }
            tail.next = null;
            head = tail = null;
        }
        length = 0;
        return true;
    }

    public static void main(String[]args){
        CSLinkedList l = new CSLinkedList();
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
            System.err.print("Enter 7 to pop first element from LinkedList\n");
            System.out.print("Enter 8 to Delete the LinkedList\n");
            System.out.print("Enter 9 for exiting LinkedList application...\n");
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
                    System.out.println("Poped item:"+l.fpop());
                    break;
                case 8:
                    System.out.println("Linked List deleted");
                    l.DeleteLinkedList();
                    break;
                default:
                    System.out.println("Invalid Input...");
                    break;
            }

        }while(opt != 9);
        sc.close();
    }
}
