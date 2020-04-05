/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author Harshit
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        LevelOrderTraversal(root);
    }

    private static void LevelOrderTraversal(Node root) {
        int height = getHeight(root);
        System.out.println("Height: " + height);

        // Print each nodes by a level
        for (int i = 1; i <= height; i++) {
            printLevelOrder(root, i);
        }
    }

    private static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private static void printLevelOrder(Node root, int height) {
        if (root == null) {
            return;
        }
        if (height == 1) {
            System.out.print(root.data + " ");
        }
        printLevelOrder(root.left, height - 1);
        printLevelOrder(root.right, height - 1);

    }
}
