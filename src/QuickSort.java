/**
 * A simple quick sort example on integer arrays
 *  
 * @author Carl Atwell
 * Date: 12/18/2019
 *
 */
public class QuickSort {
	
	/**
	 * Primary method be called a quicksort. Works recursively
	 * @param arr: Array to be sorted
	 * @param left: Left boundary of a partition
	 * @param right: Right boundary of a partition 
	 */
	public void sort(int[] arr, int left, int right){
		
		//if there is nothing left to partition
		if(left < right) {
			//sort array around the pivot
			int pivot = partition(arr, left, right);
			
			//recursively call sort
			this.sort(arr, left, pivot - 1);
			this.sort(arr, pivot + 1, right);
		}
	}
	
	/**
	 * Helper method for sorting an array around the pivot
	 * @param arr: Array to sort
	 * @param left: Left boundary of the partition
	 * @param right: Right boundary of the partition
	 * @return: The new index of the pivot
	 */
	private int partition(int arr[], int left, int right) {
		int pivotVal = arr[right];
		int tracker = left -1;
		//for all indexes in range of partiton
		for(int index = left; index < right; index++) {
			//if the value at this index is less than the pivot keep it the left 
			if(arr[index] <= pivotVal) {
				tracker++;
				swap(arr, tracker, index);
			}
		}
		
		//swap the pivot to the correct spot
		int temp = arr[tracker + 1];
		arr[tracker + 1] = arr[right];
		arr[right] = temp;
		
		return tracker + 1;
	}
	
	/**
	 * Helper method for swapping two values positions in an array
	 * @param arr: Array where swapping occurs.
	 * @param tracker: Index of one of the values
	 * @param index: Index of the second value.
	 */
	private void swap(int arr[], int tracker, int index) {
		int temp = arr[tracker];
		arr[tracker] = arr[index];
		arr[index] = temp;
	}
}
