import java.util.Random;
import java.util.Scanner;

public class Sorters {

	public static void main(String[] args) {
		Sorters sorters = new Sorters();
		Scanner scan = new Scanner(System.in);
		System.out.println("__________Sorting Algorithms__________");
		System.out.println("BubbleSort(ID = 1) QuickSort(ID = 2)");
		int id = -1;
		
		while(id != 0) {
			System.out.print("Enter an algorithm id: ");
			id = scan.nextInt();
			System.out.println();
			
			if(id == 0) {
				break;
			}
			System.out.print("How many number to sort? ");
			int length = scan.nextInt();
			int[] arr = sorters.generate(length);
			if(id == 1) {
				System.out.println("Array sorted = " + sorters.isSorted(arr));
				BubbleSort bubbleSort = new BubbleSort();
				bubbleSort.sort(arr);
				System.out.println("Array Sorted = " + sorters.isSorted(arr));
				sorters.print(arr, scan);
			}
			else if(id == 2) {
				System.out.println("Array sorted = " + sorters.isSorted(arr));
				QuickSort quickSort = new QuickSort();
				quickSort.sort(arr, 0, arr.length - 1);
				System.out.println("Array Sorted = " + sorters.isSorted(arr));
				sorters.print(arr, scan);
			}
			else{
				System.out.println("Invalid input, please try again");
			}	
			
			
		}
		
		System.out.println("Adios!");
		scan.close();
		
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
			this.print(arr, scan);
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
