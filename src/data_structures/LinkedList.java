package data_structures;

public class LinkedList {
    Node head;
    int elemCount;

    public LinkedList() {
        head = null;
    }

    public void add(int data) {
        if (head == null)
            head = new Node(data);
        else {
            Node temp = new Node(data);
            if (head.next == null)
                head.next = temp;
            else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = temp;
            }
        }
        elemCount++;
    }

    private static void removeElementAtIndex(LinkedList ls, int index) {
        int counter = 1;
        Node temp = ls.head;
        while (counter < index - 1) {
            temp = temp.next;
            counter++;
        }
        temp.next = temp.next.next;
        ls.elemCount--;
    }

    private static void revereseLinkedListIterative(LinkedList ls) {
        if (ls.head != null) {
            Node current = ls.head;
            Node prev = null;
            while (current != null) {
                Node temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            }
            // This line is important don't forget to write this line
            ls.head = prev;
        }

    }

    private static Node reverseLinkedListRecursive(Node head) {
        // Go to the last element of Linked list
        if (head == null || head.next == null) {
            return head;
        }
        Node last = reverseLinkedListRecursive(head.next);

        // Now reverse the link of head
        head.next.next = head; // reverse the link
        head.next = null; // remove current link

        return last;
    }

    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.add(10);
        ls.add(20);
        ls.add(30);
        ls.add(60);
        ls.add(50);
        printList(ls);
        System.out.println("Total elements: " + ls.elemCount);
        removeElementAtIndex(ls, 3);
        printList(ls);
        System.out.println("Total elements: " + ls.elemCount);
        ls.add(30);
        printList(ls);

        revereseLinkedListIterative(ls);
        System.out.println("Reverse Linked list iterative way: ");
        printList(ls);

        // recursive linked list
        Node head = reverseLinkedListRecursive(ls.head);
        ls.head = head;

        System.out.println("Reverse Linked list recursive way: ");
        printList(ls);
    }

    private static void printList(LinkedList ls) {
        if (ls.head != null) {
            Node temp = ls.head;
            System.out.print("[" + temp);
            while (temp.next != null) {
                temp = temp.next;
                System.out.print(" " + temp);
            }
            System.out.println("]");
        }
    }

    class Node {
        Node next;
        int data;

        public Node(int data) {
            next = null;
            this.data = data;
        }

        @Override
        public String toString() {
            return "" + data;
        }
    }
}
