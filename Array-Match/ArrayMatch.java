/* 
 * CSC 225 - Assignment 3
 * Name: 
 * Student number:
 */
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.Arrays;

public class ArrayMatch {

	/*
	 * match
	 * Purpose: Determine if the two given arrays 'match'
	 * Parameters: int[] a, int[] b - the two arrays
	 * Returns: boolean - true if arrays 'match', false otherwise
	 * Preconditions: a and b have the same number of elements
	 */
	public static boolean match(int[] a, int[] b) {
		// compute array length
		int len = a.length;

		// return true if a and b are identical
		if (isEqual(a, b)) {
			return true;
		}

		// return false if array length is odd
		if (len % 2 > 0) {
			return false;
		}
		
		// split arrays
		int[] a1 = Arrays.copyOfRange(a, 0, len/2);
		int[] a2 = Arrays.copyOfRange(a, len/2, len);
		int[] b1 = Arrays.copyOfRange(b, 0, len/2);
		int[] b2 = Arrays.copyOfRange(b, len/2, len);

		// match sub arrays
		boolean a1b1 = match(a1, b1);
		boolean a1b2 = match(a1, b2);
		boolean a2b1 = match(a2, b1);
		boolean a2b2 = match(a2, b2);

		// condition a
		if (a1b1 && a2b2) {
			return true;
		}
		
		// condition b
		if (a1b1 && a1b2) {
			return true;
		}

		// condition c
		if (a2b1 && a2b2) {
			return true;
		}

		// default
		return false;
	}

	private static boolean isEqual(int[] a, int[] b) {
		// Compare a and b element by element
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	/*
	 * fillArray
	 * Purpose: Fills arrays with contents read from Scanner
	 * Parameters: int[] x, Scanner fileReader
	 * Returns: nothing
	 */
	public static void fillArray(int[] x, Scanner fileReader) throws NoSuchElementException {
		Scanner f = new Scanner(fileReader.nextLine());
		for (int i = 0; i < x.length; i++) {
			x[i] = f.nextInt();
		}
	}
		
	/*
	 * a3Setup
	 * Purpose: Initializes the input arrays for Assignment 3 match detection
	 *          by reading data from the text file named fname
	 * Parameters: String fname - name of the file containig input data
	 * Returns: nothing
	 */
	public static void a3Setup(String fname) {
		Scanner fileReader = null;
		int[] A = null;
		int[] B = null;
		
		try {
			fileReader = new Scanner(new File(fname));
		} catch (FileNotFoundException e) {
			System.out.println("Error finding input file");
			e.printStackTrace();
			return;
		}
		
		try {
			int size = Integer.parseInt(fileReader.nextLine());
			A = new int[size];
			B = new int[size];
			fillArray(A, fileReader);
			fillArray(B, fileReader);
		} catch (NoSuchElementException e) {
			System.out.println("Error reading input file data");
			e.printStackTrace();
		}
		
		if (match(A,B)) {
			System.out.println("match found");
		} else {
			System.out.println("no matches");
		}
	}
	
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Incorrect usage, should be:");
			System.out.println("java MysteryArray filename.txt");
			return;
		}
		a3Setup(args[0]);
	}
}