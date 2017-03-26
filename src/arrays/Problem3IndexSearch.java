package arrays;

/**
 * You are given A[1:::n], a sorted array of distinct integers. Design an
 * algorithm that runs in O(log n) time that determines if there exists an
 * integer k such that A[k] = k.
 * 
 * Comments: Same as Binary Search Algorithm. Just comparing with mid value
 * because we do not have search key. Comparing k-a[k] and returning True when
 * k-a[k]=0.
 * 
 * @author Harshit
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem3IndexSearch {

	static final String CURRENT_DIR = System.getProperty("user.dir");
	static final String CURRENT_PACKAGE = "/src/bezakova/homework1/";
	static final String INPUT_FILE =  CURRENT_DIR + CURRENT_PACKAGE + "prblm3_input.txt";

	private boolean IndexSearch(int[] a) {
		int low = 0;
		int high = a.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (mid < a[mid])
				high = mid - 1;
			else if (mid > a[mid])
				low = mid + 1;
			else
				return true;
		}
		return false;
	}

	private int[] convertStringArrayToInteger(String[] temp) {
		int[] a = new int[temp.length];
		for (int i = 0; i < temp.length; i++) {
			a[i] = Integer.parseInt(temp[i]);
		}
		return a;
	}

	public static void main(String[] args) throws IOException {

		Problem3IndexSearch object = new Problem3IndexSearch();
		@SuppressWarnings("unused")
        int n = 0;
		String values = "";

		BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE));
		String line = "";
		int line_no = 1;
		while ((line = br.readLine()) != null) {
			if (line_no == 1)
				n = Integer.parseInt(line);
			else {
				values = line;
			}
			line_no++;
		}

		String[] temp = values.split("\\s");
		int[] a = object.convertStringArrayToInteger(temp);

		boolean search = object.IndexSearch(a);
		System.out.println(search);

		br.close();
	}
}
