package basics.problem_solving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Harshit
 */
public class Tree {

    int value;
    Tree left;
    Tree right;

    public Tree(int value) {
        this.value = value;
    }

    /**
     * Binary Tree height/depth/level. Considered root at level 1 and empty tree
     * hash height 0.
     *
     * @param tree
     * @return
     */
    private static int getTreeHeight(Tree tree) {
        if (tree == null) {
            return 0;
        }
        return Math.max(getTreeHeight(tree.left), getTreeHeight(tree.right)) + 1;
    }

    private static void inorderTraversal(Tree tree) {
        if (tree == null) {
            return;
        }

        inorderTraversal(tree.left);
        System.out.print(tree.value + " ");
        inorderTraversal(tree.right);
    }

    /**
     * Preorder of a binary tree is a DFS.
     *
     * @param tree
     */
    private static void preorderTraversal(Tree tree) {
        if (tree == null) {
            return;
        }

        System.out.print(tree.value + " ");
        preorderTraversal(tree.left);
        preorderTraversal(tree.right);
    }

    private static void postorderTraversal(Tree tree) {
        if (tree == null) {
            return;
        }

        postorderTraversal(tree.left);
        postorderTraversal(tree.right);
        System.out.print(tree.value + " ");
    }

    /**
     * This is simple and using queue.
     *
     * Time complexity: O(n), Space complexity: O(n)
     *
     * For recursive solution (using internal stack), you can follow the
     * solution in the package: trees.BinaryTreeLevelOrderTraversal
     *
     * @param tree
     */
    private static void bfsOfBinaryTree(Tree tree) {
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            Tree node = queue.poll();
            System.out.print(node.value + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * The simple solution using external stack (data structure).
     *
     * Time complexity: O(n), Space complexity: O(n)
     *
     * For recursive solution (using internal stack), same as Preorder
     * traversal.
     *
     * @param tree
     */
    private static void dfsOfBinaryTree(Tree tree) {
        Stack<Tree> stack = new Stack<>();
        stack.push(tree);
        while (!stack.empty()) {
            Tree node = stack.pop();
            System.out.print(node.value + " ");
            if (node.right != null) {   // Remember to push right children first.
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(3);
        tree.left.left = new Tree(4);
        tree.left.right = new Tree(5);
        tree.right.left = new Tree(6);
        tree.right.right = new Tree(7);

        System.out.println("Printing original tree");
        BTreePrinter.printNode(tree);

        int height = getTreeHeight(tree);
        System.out.println("Height of the tree: " + height);

        System.out.print("Inorder traversal : ");
        inorderTraversal(tree);
        System.out.println("");

        System.out.print("Preorder (DFS) traversal : ");
        preorderTraversal(tree);
        System.out.println("");

        System.out.print("Postorder traversal : ");
        postorderTraversal(tree);
        System.out.println("");

        System.out.print("Breadth First Search(BFS) of a binary tree : ");
        bfsOfBinaryTree(tree);
        System.out.println("");

        System.out.print("Depth First Search(DFS) of a binary tree : ");
        dfsOfBinaryTree(tree);
        System.out.println("");
    }
}

/**
 * Class to print binary tree. Ref:
 * https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram/4973083#4973083
 *
 * @author Harshit
 */
class BTreePrinter {

    public static void printNode(Tree root) {
        int maxLevel = maxLevel(root); // height of the tree.
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<Tree> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) {
            return;
        }

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<Tree> newNodes = new ArrayList<>();
        nodes.stream().map((node) -> {
            if (node != null) {
                System.out.print(node.value);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }
            return node;
        }).forEachOrdered((_item) -> {
            printWhitespaces(betweenSpaces);
        });
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null) {
                    System.out.print("/");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null) {
                    System.out.print("\\");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private static int maxLevel(Tree node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static boolean isAllElementsNull(List<Tree> treeNode) {
        return treeNode.stream().allMatch((node) -> (node == null));
    }
}
