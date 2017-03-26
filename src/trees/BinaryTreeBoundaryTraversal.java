/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 * http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 *
 * @author Harshit
 */
public class BinaryTreeBoundaryTraversal {

    Node root;

    void printBoundaryLeft(Node node) {
        if (node != null) {
            if (node.left != null) {
                System.out.print(node.data + " ");
                printBoundaryLeft(node.left);
            } else if (node.right != null) {
                System.out.print(node.data + " ");
                printBoundaryLeft(node.right);
            }
        }
    }

    void printLeaves(Node node) {
        if (node != null) {
            printLeaves(node.left);

            if (node.left == null && node.right == null) {
                System.out.print(node.data + " ");
            }
            printLeaves(node.right);
        }
    }

    void printBoundaryRight(Node node) {
        if (node != null) {
            if (node.right != null) {
                printBoundaryRight(node.right);
                System.out.print(node.data + " ");
            } else if (node.left != null) {
                printBoundaryRight(node.left);
                System.out.print(node.data + " ");
            }
        }
    }

    void printBoundary(Node node) {
        if (node != null) {

            printBoundaryLeft(node.left);

            printLeaves(node.left);
            printLeaves(node.right);

            printBoundaryRight(node.right);
        }
    }

    public static void main(String args[]) {
        new BinaryTreeBoundaryTraversal().createTreeAndCallBoundary();
    }

    private void createTreeAndCallBoundary() {
        BinaryTreeBoundaryTraversal tree = new BinaryTreeBoundaryTraversal();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        tree.printBoundary(tree.root);
    }

    class Node {

        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }

    }
}
