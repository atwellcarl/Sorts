/**
 * A simple quick sort example on integer arrays
 *  
 * @author Carl Atwell
 * Date: 12/18/2019
 *
 */
public class QuickSort {
	
	public void sort(int[] arr, int left, int right){
		//if the partition is greater than one
		if(left < right) {
		
			int pivot = partition(arr, left, right);
			
			this.sort(arr, left, pivot - 1);
			this.sort(arr, pivot + 1, right);
		}
	}
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
		
		int temp = arr[tracker + 1];
		arr[tracker + 1] = arr[right];
		arr[right] = temp;
		
		return tracker + 1;
	}
	
	private void swap(int arr[], int tracker, int index) {
		int temp = arr[tracker];
		arr[tracker] = arr[index];
		arr[index] = temp;
	}
}
