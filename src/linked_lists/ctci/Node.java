package linked_lists.ctci;

/**
 * Simple Implementation of Linkedlist. (add, delete methods)
 *
 * @author Harshit
 */
public class Node {

    public Node next;
    public int data;

    public Node(int data) {
        this.data = data;
    }

    public void appendToTail(int data) {
        Node end = new Node(data);
        Node current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = end;
    }
    
    public Node deleteNode(int data) {
        Node head = this;

        if (head.data == data) {
            return head.next; // moved head
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return head; // head didn't change
            }
            current = current.next;
        }
        return head;
    }

    @Override
    public String toString() {
        Node node = this;
        String str = "[";
        while (node.next != null) {
            str += node.data + ", ";
            node = node.next;
        }

        str += node.data + "]";
        return str;
    }

    public static void main(String[] args) {

        Node list = new Node(5);
        list.appendToTail(10);
        list.appendToTail(15);
        list.appendToTail(20);
        System.out.println(list);

        list = list.deleteNode(15);
        System.out.println(list);
    }
}
