
import java.util.Random;
import java.util.Scanner;
/**
 * A class for displaying the valididty and usefulness of the various sort algorithms
 * @author Carl Atwell
 * Date: 10/18/2019
 */
public class Sorters {

	/**
	 * Main creates a sorter and calls method to get user input
	 * @param args
	 */
	public static void main(String[] args) {
		Sorters sorters = new Sorters();
		Scanner scan = new Scanner(System.in);
		System.out.println("__________________Sorting Algorithms_________________");
		System.out.println("BubbleSort(ID = 1) QuickSort(ID = 2) MergeSort(ID = 3");
		
		sorters.getInput(scan);
		System.out.println("Adios!");	
	}
	
	/**
	 * Get user input for which sort to execute
	 * @param scan: Scanner for console input
	 */
	private void getInput(Scanner scan) {
		int id = -1 ;
		System.out.println();
		System.out.print("Enter an algorithm id: ");
		
		if(scan.hasNextInt()) {
			id = scan.nextInt();
		}
		else {
			System.out.println("Invalid input");
			return;
		}
		//0 to quit program
		if(id == 0) {
			scan.close();
			return;
		}
		//execute a bubble sort
		else if(id == 1) {
			this.runBubbleSort(scan);
		}
		//execute a quicksort
		else if(id == 2) {
			this.runQuickSort(scan);
		}
		//execute a mergesort
		else if(id == 3) {
			this.runMergeSort(scan);
		}
		else{
			System.out.println("Invalid input");
			return;
		}
	}

	/**
	 * Helper method for prompting the user for the legth of an array to sort
	 * and calls a merge sort. once merge is done the user will be asked if the
	 * array should be printed.
	 * 
	 * @param scan: Scanner for console input
	 */
	private void runMergeSort(Scanner scan) {
		//get user input
		System.out.print("How many to sort? ");
		int length = 0;
		if(scan.hasNextInt()) {
			length = scan.nextInt();
		}
		else {
			System.out.println("Invalid input");
			return;
		}
		
		//call the sort, verify order before and after sort
		int[] arr = this.generate(length);
		System.out.println("Array sorted = " + this.isSorted(arr));
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(arr);
		System.out.println("Array Sorted = " + this.isSorted(arr));
		
		this.print(arr, scan);
		this.getInput(scan);
	}

	/**
	 * Helper method for running a quick sort. User is asked how mant 
	 * integers to sort. After sorting the user is asked if the array
	 * should be printed.
	 * 
	 * @param scan: Scanner for console input
	 */
	private void runQuickSort(Scanner scan) {
		//Get user input
		System.out.print("How many to sort? ");
		int length = 0;
		if(scan.hasNextInt()) {
			length = scan.nextInt();
		}
		else {
			System.out.println("Invalid input");
			return;
		}
		
		//Sort array. Verify before and after.
		int[] arr = this.generate(length);
		System.out.println("Array sorted = " + this.isSorted(arr));
		QuickSort quickSort = new QuickSort();
		quickSort.sort(arr, 0, arr.length - 1);
		System.out.println("Array Sorted = " + this.isSorted(arr));
		this.print(arr, scan);
		this.getInput(scan);
		
	}

	/**
	 * Run a bubble sort. User is asked how many integers to sort before
	 * sorting begins. After sorting, the user is asked if the array 
	 * should be printed.
	 * 
	 * @param scan: Scanner for console input
	 */
	private void runBubbleSort(Scanner scan) {
		//get user input
		System.out.print("How many to sort? ");
		int length = 0;
		if(scan.hasNextInt()) {
			length = scan.nextInt();
		}
		else {
			System.out.println("Invalid input");
			return;
		}
		
		//Run sort
		int[] arr = this.generate(length);
		System.out.println("Array sorted = " + this.isSorted(arr));
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(arr);
		System.out.println("Array Sorted = " + this.isSorted(arr));
		this.print(arr, scan);
		this.getInput(scan);
	}

	/**
	 * Ask user if the array should be printed. Prints array
	 * if input is "yes"
	 * @param arr: Array to print
	 * @param scan: Scanner for console input
	 */
	private void print(int arr[], Scanner scan) {
		
		System.out.print("Would you like the array printed? (yes/no): ");
		String print = scan.next();
		
		if(print.equals("yes")) {
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		else if(print.equals("no")) {
			return;
		}
		else {
			System.out.println("Invalid Input!");
			return;
		}
	}
	
	/**
	 * Uses Math.Random to create place integers in an array
	 * @param length: length of the array
	 * @return: Array filled with random integers.
	 */
	private int[] generate(int length) {
		int arr[] = new int[length];
		Random ran  = new Random();
		for(int i = 0; i< length; i++) {
			arr[i] = ran.nextInt();
		}
		return arr;		
	}
	
	/**
	 * Checks if an array is sorted
	 * @param arr: Array to check order.
	 * @return: Boolean true if array is sorted. False otherwise
	 */
	private boolean isSorted(int[] arr) {
		boolean sorted = true;
		
		int prev = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < prev) {
				return false;
			}
			prev = arr[i];
		}
		return sorted;
	}
}
