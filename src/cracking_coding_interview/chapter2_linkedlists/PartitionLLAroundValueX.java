/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cracking_coding_interview.chapter2_linkedlists;

/**
 *
 * @author Harshit
 */
public class PartitionLLAroundValueX {

    /**
     * Solution: Approach would be to create two lists and store values smaller
     * than x into first list and greater than or equal to x in the second list.
     *
     * Note: both linkedlist orders will be different. If you want to maintain
     * order then reverse both the linked list before merging them.
     *
     * @param list
     * @param x
     */
    public static Node partitionLinkedListAroundValueX(Node list, int x) {
        Node firstlist = null;
        Node secondlist = null;

        // partition list
        while (list != null) {
            Node next = list.next;
            // Insert into the front of respective lists.
            if (list.data < x) {
                list.next = firstlist;
                firstlist = list;
                
            } else {
                list.next = secondlist;
                secondlist = list;
            }
//            System.out.println("first" + firstlist);
//            System.out.println("second" + secondlist);
            list = next;
        }

        // Merge both the lists.
        if (firstlist == null) {
            return secondlist;
        }

        // Find the reference of the end of the first list and point it to the beginning of the second list.
        Node head = firstlist;
        while (firstlist.next != null) {
            firstlist = firstlist.next;
        }
        firstlist.next = secondlist;

        return head;
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

        Node new_list = partitionLinkedListAroundValueX(list, 15);

        System.out.println(new_list);
    }
}
