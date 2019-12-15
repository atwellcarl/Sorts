
public class BubbleSort {
	
	public void sort(int[] arr) {
		
		boolean sorted = false;
		
		while(!sorted) {
			boolean swaped = false;
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

	private void swap(int[] arr, int index, int temp, int temp2) {
		arr[index] = temp2;
		arr[index + 1] = temp;
	}
}
