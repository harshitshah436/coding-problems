/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_lists.ctci;

/**
 * Add two numbers represented by linked lists.
 *
 * Representation two different forms: 1. head of the node is represented by
 * Least Significant Beat (LSB). 2. head of the node is represented by Most
 * Significant Beat (MSB)
 *
 * Reference: 1.
 * http://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/ 2.
 * https://leetcode.com/problems/add-two-numbers-ii/discuss/92623/Easy-O(n)-Java-Solution-using-Stack
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
     * @return Node
     */
    public static Node SumOfTwoNumbersOfLL(Node list, Node list2) {
        Node dummyHead = new Node(0);
        Node current = dummyHead;
        int carry = 0;

        // Check lists are null for different sizes
        while (list != null || list2 != null) {
            int sum = carry;

            if (list != null) {
                sum += list.data;
                list = list.next;
            }

            if (list2 != null) {
                sum += list2.data;
                list2 = list2.next;
            }

            carry = sum / 10;
            sum = sum % 10;

            current.next = new Node(sum);
            current = current.next;
        }

        if (carry > 0) {
            current = new Node(carry);
        }

        return dummyHead.next;
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

        Node result = SumOfTwoNumbersOfLL(list, list2);
        System.out.println(result);
    }
}
