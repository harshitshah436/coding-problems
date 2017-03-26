/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cracking_coding_interview.chapter2_linkedlists;

/**
 * Add two numbers represented by linked lists.
 *
 * Representation two different forms: 1. head of the node is represented by
 * Least Significant Beat (LSB). 2. head of the node is represented by Most
 * Significant Beat (MSB)
 *
 * Reference: 1.
 * http://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/ 2.
 *
 * @author Harshit
 */
public class SumOfTwoNumbersInLL {

    /**
     * This method works for condition 1. head of the node is represented by
     * Least Significant Beat (LSB).
     *
     * Time complexity: O(m + n) where m,n are number of elements in both the
     * lists.
     *
     * @param list
     * @param list2
     */
    @SuppressWarnings("null")
    public static void SumOfTwoNumbersOfLL(Node list, Node list2) {
        int carry = 0;
        Node result = null;
        Node rest = null;
        boolean firstNode = true;
        while (list != null || list2 != null) {

            int sum = (list != null ? list.data : 0) + (list2 != null ? list2.data : 0) + carry;

            carry = sum / 10;
            sum = sum % 10;

            Node temp = new Node(sum);

            // if this is the first node then set it as head of the result list
            if (firstNode) {
                result = temp;
                firstNode = false;
            } else { // If this is not the first node then connect it to the rest.
                rest.next = temp;
            }

            // Set rest for next insertion
            rest = temp;

            if (list != null) {
                list = list.next;
            }
            if (list2 != null) {
                list2 = list2.next;
            }
        }
        if (carry > 0) {
            Node temp = result;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.data = temp.data + carry * 10;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Node list = new Node(7);
        list.appendToTail(1);
        list.appendToTail(6);

        System.out.println(list);

        Node list2 = new Node(5);
        list2.appendToTail(9);
        list2.appendToTail(4);

        System.out.println(list2);

        SumOfTwoNumbersOfLL(list, list2);
    }
}
