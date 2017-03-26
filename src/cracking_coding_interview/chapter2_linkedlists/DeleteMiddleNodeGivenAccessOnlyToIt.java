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
public class DeleteMiddleNodeGivenAccessOnlyToIt {

    /**
     * Simple approach: assign current node (middle node) the values of the next
     * node. And delete the next node.
     *
     * @param list
     */
    public static void deleteMiddleNodeGivenAccessOnlyToIt(Node list) {
        if (list == null || list.next == null) {
            return;
        }
        Node next = list.next;
        list.data = next.data;
        list.next = next.next;
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

        while (list.next != null) {
            if (list.data == 10) {
                deleteMiddleNodeGivenAccessOnlyToIt(list);
                break;
            }
            list = list.next;
        }

        System.out.println(list);
    }
}
