/* 
 * CSC 225 - Assignment 3
 * Name: 
 * Student number:
 */
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class ArrayMatch {

	/*
	 * match
	 * Purpose: Determine if the two given arrays 'match'
	 * Parameters: int[] a, int[] b - the two arrays
	 * Returns: boolean - true if arrays 'match', false otherwise
	 * Preconditions: a and b have the same number of elements
	 */
	public static boolean match(int[] a, int[] b) {
		// compute array length once to save time
		int len = a.length;

		// Check if a and b are identical
		if (fullMatch(a, b, len)){
			return true;
		}

		// if array length is even
		if (len % 2 == 0){
			// Split a and b in half
			int[] a1 = new int[len/2];
			int[] a2 = new int[len/2];
			int[] b1 = new int[len/2];
			int[] b2 = new int[len/2];

			// fill arrays
			for (int i = 0; i < a.length/2; i++) {
				a1[i] = a[i];
				b1[i] = b[i];
				a2[i] = a[i + len/2];
				b2[i] = b[i + len/2];
			}	

			// a1 matches b1 and a2 matches b2
			if (fullMatch(a1, b1, len/2) && fullMatch(a2, b2, len/2)) {
				return true;
			}

			// a1 matches b1 and a1 matches b2
			if (fullMatch(a1, b1, len/2) && fullMatch(a1, b2, len/2)) {
				return true;
			}

			// a2 matches b1 and a2 matches b2
			if (fullMatch(a2, b1, len/2) && fullMatch(a2, b2, len/2)) {
				return true;
			}
		}
		
		return false;
	}

	private static boolean fullMatch(int[] a, int[] b, int len) {
		// Compare a and b element by element
		for (int i = 0; i < len; i++) {
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