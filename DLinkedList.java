import java.util.Scanner;

public class DLinkedList {
    static class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node tail;
    public int length;

    public DLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Boolean insert(int index , int value) {
        Node newNode = new Node(value);
        if (index < 0 || index > length) {
            return false;
        } else if (length == 0) {
            head = newNode;
            tail = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node temp = head;
            for(int i=0 ; i<index-1 ; i++) {
                temp = temp.next;
            }
            newNode.prev = temp;
            newNode.next = temp.next;

            if(temp.next != null) {
                temp.next.prev = newNode;
            } else {
                tail = newNode;
            }
            temp.next = newNode;
        }
        length++;
        return true;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            result.append(temp.value);
            temp = temp.next;
            if (temp != null) {
                result.append("<->");
            }
        }
        return result.toString();
    }

    public String revToString() {
        StringBuilder result = new StringBuilder();
        Node temp = tail;
        while (temp != null) {
            result.append(temp.value);
            temp = temp.prev;
            if (temp != null) {
                result.append("<->");
            }
        }
        return result.toString();
    }

    public int search(int target) {
        int index = -1;
        Node temp = head;
        while (temp != null) {
            if(temp.value == target) {
                return index + 1;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public int get(int index) {
        if (index < 0 || index >= length) {
            return -1;
        }
        int value;
        if (index <= length / 2) {
            Node temp = head;
            for (int i=0 ; i < index ; i++) {
                temp = temp.next;
            }
            value = temp.value;
        } else {
            Node temp = tail;
            for(int i=length-1 ; i > index ; i--) {
                temp = temp.prev;
            }
            value = temp.value;
        }
        return value;
    }

    public Boolean set(int index , int value) {
        if(index < 0 || index > length) {
            return false;
        }
        Node temp = head;
        for (int i=0 ; i<index ; i++) {
            temp = temp.next;
        }
        temp.value = value;
        return true;
    }

    public int pop() {
        if (length == 0) {
            return -1;
        }
        int value = tail.value;
        if (length == 1) {
            head = tail = null;
        } else {
           tail = tail.prev;
           tail.next = null;
        }
        length--;
        return value;
    }
    
    
    public static void main(String[] args) {
        DLinkedList list = new DLinkedList();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\nDoubly Linked List Operations:");
            System.out.println("1. Append");
            System.out.println("2. Prepend");
            System.out.println("3. Insert");
            System.out.println("4. Pop");
            System.out.println("5. Print");
            System.out.println("6. Print in Reverse");
            System.out.println("7. Search");
            System.out.println("8. Get");
            System.out.println("9. Set");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to append: ");
                    int appendValue = scanner.nextInt();
                    list.append(appendValue);
                    break;
                case 2:
                    System.out.print("Enter value to prepend: ");
                    int prependValue = scanner.nextInt();
                    list.prepend(prependValue);
                    break;
                case 3:
                    System.out.print("Enter index to insert: ");
                    int insertIndex = scanner.nextInt();
                    System.out.print("Enter value to insert: ");
                    int insertValue = scanner.nextInt();
                    list.insert(insertIndex, insertValue);
                    break;
                case 4:
                    list.pop();
                    System.out.println("Last element popped.");
                    break;
                case 5:
                    System.out.println("Doubly Linked List: " + list.toString());
                    break;
                case 6:
                    System.out.println("Doubly Linked List in Reverse: " + list.revToString());
                    break;
                case 7:
                    System.out.print("Enter value to search: ");
                    int searchValue = scanner.nextInt();
                    int searchResult = list.search(searchValue);
                    if (searchResult != -1) {
                        System.out.println("Value found at index: " + searchResult);
                    } else {
                        System.out.println("Value not found in the list.");
                    }
                    break;
                case 8:
                    System.out.print("Enter index to get value: ");
                    int getIndex = scanner.nextInt();
                    int getValue = list.get(getIndex);
                    if (getValue != -1) {
                        System.out.println("Value at index " + getIndex + ": " + getValue);
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 9:
                    System.out.print("Enter index to set value: ");
                    int setIndex = scanner.nextInt();
                    System.out.print("Enter new value: ");
                    int setValue = scanner.nextInt();
                    boolean setResult = list.set(setIndex, setValue);
                    if (setResult) {
                        System.out.println("Value set successfully.");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 0);
        
        scanner.close();
    }
}

