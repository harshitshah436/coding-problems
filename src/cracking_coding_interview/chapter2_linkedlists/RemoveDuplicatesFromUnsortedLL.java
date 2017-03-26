/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cracking_coding_interview.chapter2_linkedlists;

import java.util.HashSet;

/**
 * Remove duplicates from an unsorted linked list
 *
 * (try without using any temporary buffer)
 *
 * @author Harshit
 */
public class RemoveDuplicatesFromUnsortedLL {

    /**
     * Remove duplicates from unsorted linked list. Temporary buffer is strictly
     * not allowed in this implementation.
     *
     * Here, temporary buffer means hashtable/hashmap.
     *
     * So, we will use two pointers, one for iterating the linked list and other
     * for removing duplicates from LL.
     * 
     * Time complexity: O(n^2), space complexity: O(1)
     *
     * @param head
     * @return
     */
    public static void removeDuplicatesFromUnsortedLinkedList(Node head) {

        if (head.next == null) {
            return;
        }

        Node current = head; // pointer one to iterate through LL.
        while (current != null) {
            Node running = current; // pointer two to remove duplicates.
            while (running.next != null) {
                if (current.data == running.next.data) {
                    running.next = running.next.next;
                } else {
                    running = running.next;
                }
            }
            current = current.next;
        }
    }

    /**
     * Remove duplicates from unsorted linked list. Temporary buffer allowed in
     * this implementation.
     *
     * Time complexity: O(n), space complexity: O(n)
     * 
     * @param head
     * @return
     */
    public static void removeDuplicatesFromUnsortedLinkedList_TemporaryBufferAllowed(Node head) {

        if (head.next == null) {
            return;
        }

        // O(n) approach using HashSet because searching is O(1);
        HashSet<Integer> hashset = new HashSet<Integer>();
        hashset.add(head.data);
        while (head.next != null) {
            if (hashset.contains(head.next.data)) {
                head.next = head.next.next;
            } else {
                hashset.add(head.next.data);
                head = head.next;
            }
        }
    }

    public static void main(String[] args) {

        Node list = new Node(5);
        list.appendToTail(15);
        list.appendToTail(20);
        list.appendToTail(10);
        list.appendToTail(5);
        list.appendToTail(15);
        System.out.println(list);

        removeDuplicatesFromUnsortedLinkedList_TemporaryBufferAllowed(list);
        System.out.println(list);

        list.appendToTail(5);
        list.appendToTail(15);
        list.appendToTail(25);
        System.out.println(list);

        removeDuplicatesFromUnsortedLinkedList(list);
        System.out.println(list);
    }
}
