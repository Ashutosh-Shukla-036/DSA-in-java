public class ReverseLinkedList {
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

    public ReverseLinkedList() {
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

    void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
    
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    
        head = prev; 
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

    public static void main(String[] args) {
        ReverseLinkedList l = new ReverseLinkedList();
        l.append(10);
        l.append(20);
        l.append(30);
        l.append(40);
        l.append(50);
    
        System.out.println("Original linked list: " + l.toString());
    
        l.reverse();
    
        System.out.println("Reversed linked list: " + l.toString());
    }
    
    
}
