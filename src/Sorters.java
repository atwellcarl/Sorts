
public class Sorters {

	public static void main(String[] args) {
		Sorters sorters = new Sorters();
		int[] arr = {2, 5, 1, 3, 5, 2, 4, 6, 3, 2 ,8, 6, 44, 3, 5, 6, 4567, 4657};
		
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(arr);
		
		sorters.print(arr);
	}
	private void print(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
