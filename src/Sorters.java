
import java.util.Random;
import java.util.Scanner;
/**
 * A class for displaying the valididty and usefulness of the various sort algorithms
 * @author Carl Atwell
 * Date: 10/18/2019
 */
public class Sorters {

	public static void main(String[] args) {
		Sorters sorters = new Sorters();
		Scanner scan = new Scanner(System.in);
		System.out.println("__________Sorting Algorithms__________");
		System.out.println("BubbleSort(ID = 1) QuickSort(ID = 2)");
		
		sorters.getInput(scan);
		System.out.println("Adios!");	
	}
	
	
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
		if(id == 0) {
			scan.close();
			return;
		}
		else if(id == 1) {
			this.runBubbleSort(scan);
		}
		else if(id == 2) {
			this.runQuickSort(scan);
		}
		else{
			System.out.println("Invalid input");
			return;
		}
	}


	private void runQuickSort(Scanner scan) {
		System.out.print("How many to sort? ");
		int length = 0;
		if(scan.hasNextInt()) {
			length = scan.nextInt();
		}
		else {
			System.out.println("Invalid input");
			return;
		}
		int[] arr = this.generate(length);
		System.out.println("Array sorted = " + this.isSorted(arr));
		QuickSort quickSort = new QuickSort();
		quickSort.sort(arr, 0, arr.length - 1);
		System.out.println("Array Sorted = " + this.isSorted(arr));
		this.print(arr, scan);
		this.getInput(scan);
		
	}


	private void runBubbleSort(Scanner scan) {
		System.out.print("How many to sort? ");
		int length = 0;
		if(scan.hasNextInt()) {
			length = scan.nextInt();
		}
		else {
			System.out.println("Invalid input");
			return;
		}
		int[] arr = this.generate(length);
		System.out.println("Array sorted = " + this.isSorted(arr));
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(arr);
		System.out.println("Array Sorted = " + this.isSorted(arr));
		this.print(arr, scan);
		this.getInput(scan);
	}


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
	
	private int[] generate(int length) {
		int arr[] = new int[length];
		Random ran  = new Random();
		for(int i = 0; i< length; i++) {
			arr[i] = ran.nextInt();
		}
		return arr;		
	}
	
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
