/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_lists.ctci;

/**
 *
 * @author Harshit
 */
public class KthToLastElement {

    /**
     * Kth element from last element. The logic is to start the first pointer
     * till k elements. Second pointer will start from the head. Now, iterate
     * both pointers simultaneously end when the first pointer reaches to end
     * the second pointer will be on kth element from the last element (length -
     * k).
     *
     * time complexity : O(n), space complexity: O(1)
     *
     * @param k
     * @param head
     */
    public static void findKthToLastElementIterativeUsingTwoPointers(int k, Node head) {
        Node p1 = head, p2 = head;
        for (int i = 0; i < k - 1; i++) {
            if (p1 == null) {
                return;
            }
            p1 = p1.next;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println(p2.data);
    }

    /**
     * This is the simplest recursive method which can only used if we have to
     * print the data value and not return the node.
     *
     * If we want to return a node, then we have to user IntegerWrapper class to
     * maintain i value and return the node. (see example in the book)
     *
     * @param k
     * @param head
     * @return
     */
    public static int findKthToLastElementRecursive(int k, Node head) {
        if (head == null) {
            return 0;
        }

        int i = findKthToLastElementRecursive(k, head.next) + 1;
        if (i == k) {
            System.out.println(head.data);
        }
        return i;
    }

    /**
     * Kth to last element.
     *
     * If k=1, then return last element (length-1).
     *
     * Note: This is very basic approach won't be asked by any interviewer.
     *
     * @param k
     * @param head
     */
    public static void findKthToLastElement(int k, Node head) {
        int i = 1, length = 1;

        Node temp = head;
        while (head.next != null) {
            head = head.next;
            length++;
        }

        while (temp.next != null) {
            if (k == (length - i + 1)) {
                break;
            }
            temp = temp.next;
            i++;
        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        Node list = new Node(5);
        list.appendToTail(15);
        list.appendToTail(20);
        list.appendToTail(10);
        list.appendToTail(5);
        list.appendToTail(15);
        list.appendToTail(25);
        System.out.println(list);

        findKthToLastElement(3, list);
        findKthToLastElementIterativeUsingTwoPointers(3, list);
        findKthToLastElementRecursive(3, list);

    }
}
