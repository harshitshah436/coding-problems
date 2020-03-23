package basics.java;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This class represents useful java shortcuts for coding.
 *
 * @author Harshit
 */
public class UsefulOperations {

    public static void main(String[] args) {
        String str = "123742";

        // Check if a given string is a number (contains only digit)
        boolean bool = str.chars().allMatch(Character::isDigit);
        System.out.println(bool);

        // Convert a single character or character array to string
        char c = 's';
        str = String.valueOf(c);
        System.out.println(str);
        char[] array = new char[]{65, 97, 'A', 90, 'b', 'd'};
        str = String.valueOf(array);
        System.out.println(str);

        // Cut array or copy range of array. Arrays.copyOfRange(oldArray, startIndex, endIndex)
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        int[] new_arr = Arrays.copyOfRange(arr, 0, 3);
        System.out.println(Arrays.toString(new_arr));

        // Print array easily without iterating. Arrays.toString(arr).
        arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println(IntStream.of(arr).mapToObj(Integer::toString).collect(Collectors.joining(", ")));
        int[][] two_dim_arr = new int[][]{{0, 1}, {2, 3}};
        System.out.println(Arrays.deepToString(two_dim_arr));

        // Printf function as formatter
        System.out.printf("%3d", 8); // useful to print matrix
        System.out.println();
        System.out.printf("%15s", "Harshit"); // 15 char justified string (default: right aligned)
        System.out.println();
        System.out.printf("%-15s", "Harshit"); // left aligned
        System.out.println();
        System.out.printf("%03d", 11); // 3 decimal with 0 filled.
        System.out.println();
        System.out.printf("%-15s%03d\n", "Harshit", 11);

        // Shallow copy of an object using Object.clone() method. Also works deep copy for primitive types 1 dimentional arrays.
        int[] arr1 = arr.clone();
        arr1[2] = 1;
        System.out.println("arr" + Arrays.toString(arr));
        System.out.println("arr1" + Arrays.toString(arr1));
    }
}
