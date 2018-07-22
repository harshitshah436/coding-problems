package basics.problem_solving;

import java.util.Arrays;

/**
 * Essential matrix problems.
 *
 * @author Harshit
 */
public class Matrix {

    /**
     * Transpose the given matrix. ( rows would be columns & columns would be
     * rows).
     *
     * Here assumed same rows and columns, so we are doing it in-place without
     * extra space.
     *
     * Remember to transpose only half matrix (j==i second loop), otherwise it
     * will transpose two times and make the result to same as original.
     *
     * @param matrix
     */
    private static void transposeMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * Rotate NxN matrix by 90 degree.
     *
     * Reference:
     * https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
     *
     * @param matrix
     */
    private static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    /**
     * Rotate Matrix by easy two steps: 1) Transpose the matrix 2) Reverse
     * columns of the transpose.
     *
     * Ref:
     * https://www.geeksforgeeks.org/rotate-matrix-90-degree-without-using-extra-space-set-2/
     *
     * @param matrix1
     */
    private static void rotateMatrixTwoSteps(int[][] matrix1) {
        transposeMatrix(matrix1);
        reverseColumns(matrix1);
    }

    private static void reverseColumns(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printMatrix(matrix);

        // Deep copy for 2D arrays
        int[][] newMatrix = Arrays.stream(matrix).map(el -> el.clone()).toArray($ -> matrix.clone());
        transposeMatrix(newMatrix);
        printMatrix(newMatrix);

        newMatrix = Arrays.stream(matrix).map(el -> el.clone()).toArray($ -> matrix.clone());
        printMatrix(newMatrix);

        rotateMatrix(newMatrix);
        printMatrix(newMatrix);

        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(matrix1);
        rotateMatrix(matrix1);
        printMatrix(matrix1);

        rotateMatrixTwoSteps(newMatrix);
        printMatrix(newMatrix);

        rotateMatrixTwoSteps(matrix1);
        printMatrix(matrix1);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                System.out.printf("%4d", row[i]);
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }
}
