/**
 * A class implementing a simple bubble sort on integer arrays
 * @author Carl Atwell
 * Date: 12/18/2019
 *
 */
public class BubbleSort {
	
	/**
	 * Primary method to call the bubble sort
	 * @param arr: array to sort
	 */
	public void sort(int[] arr) {
		
		boolean sorted = false;
		
		//keep looping until there is one full loop without swapping
		while(!sorted) {
			boolean swaped = false;
			
			//loop through array and swap where needed
			for(int index = 0; index < arr.length; index ++) {
				if(index != arr.length -1) {
					int temp = arr[index];
					int temp2 = arr[index +1];
					if(temp2 < temp) {
						swaped = true;
						swap(arr, index, temp, temp2);
					}
				}
			}
			
			if(!swaped) {
				sorted = true;
			}
		}		
	}

	/**
	 * Helper method for swapping two variables
	 * @param arr: Array where swapping occurs
	 * @param index: swapping location
	 * @param temp: value to swap
	 * @param temp2: value to swap
	 */
	private void swap(int[] arr, int index, int temp, int temp2) {
		arr[index] = temp2;
		arr[index + 1] = temp;
	}
}
