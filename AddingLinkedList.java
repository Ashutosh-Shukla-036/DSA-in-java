public class AddingLinkedList {
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

    public AddingLinkedList() {
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
            tail = newNode;
        }
        length++;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            result.append(temp.value);
            temp = temp.next;
            if (temp != null) {
                result.append("->");
            }
        }
        return result.toString();
    }

    public AddingLinkedList Add(AddingLinkedList a , AddingLinkedList b) {
        Node temp1 = a.head;
        Node temp2 = b.head;
        AddingLinkedList c = new AddingLinkedList();
        int sum = 0;
        int carry = 0;

        while (temp1 != null && temp2 != null) {
            if (temp1 != null) {
                sum = sum + temp1.value;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                sum = sum + temp2.value;
                temp2 = temp2.next;
            }
            sum = sum + carry;
            c.append(sum % 10);
            carry = sum / 10;
            sum = 0;
        } 

        if (carry > 0) {
            c.append(carry);
        }

        return c;
    }

    public static void main(String[] args) {
        AddingLinkedList a = new AddingLinkedList();
        AddingLinkedList b = new AddingLinkedList();

        a.append(2);
        a.append(4);
        a.append(3);

        b.append(5);
        b.append(6);
        b.append(4);
        System.out.println(a.toString());
        System.out.println(b.toString());

        AddingLinkedList result = new AddingLinkedList();

        result = result.Add(a, b);

        System.out.println(result.toString());
    }
}
