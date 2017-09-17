package trees;

/**
 *
 * @author Harshit
 */
public class BalancedBSTFromSortedArray {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        TreeNode root = BinaryTreeFromArray(arr, 0, n - 1);
        System.out.println("Preorder traversal of constructed BST");
        inOrder(root);
    }

    private static TreeNode BinaryTreeFromArray(int[] a, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(a[mid]);

        node.left = BinaryTreeFromArray(a, start, mid - 1);
        node.right = BinaryTreeFromArray(a, mid + 1, end);

        return node;
    }

    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        inOrder(root.left);
        inOrder(root.right);
    }

    private static class TreeNode {

        TreeNode left;
        TreeNode right;
        int data;

        private TreeNode(int val) {
            data = val;
        }
    }
}
