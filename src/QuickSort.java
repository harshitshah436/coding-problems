public class QuickSort {

    public static void quickSort(int[] a, int begin, int end) {
        int p = partition(a, begin, end);
        if (begin < p - 1)
            quickSort(a, begin, p - 1);
        if (p < end)
            quickSort(a, p, end);
    }

    public static int partition(int[] a, int begin, int end) {
        int i = begin, j = end;
        int pivot = a[i];
        while (i <= j) {
            while (a[i] < pivot)
                i++;
            while (a[j] > pivot)
                j--;
            if (i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] A = { 3, -9, 5, 7, 2, 1, -5, 0 };
        quickSort(A, 0, A.length - 1);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}
