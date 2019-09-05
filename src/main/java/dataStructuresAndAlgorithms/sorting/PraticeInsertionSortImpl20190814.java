package dataStructuresAndAlgorithms.sorting;

public class PraticeInsertionSortImpl20190814 {

	public static void main(String[] args) {
		int[] input = {20, 35, -15, 7, 55, 1, 7, -22};
		PraticeInsertionSortImpl20190814 praticeInsertionSortImpl20190814 = new PraticeInsertionSortImpl20190814();
		System.out.println("before: " + input.toString());
		praticeInsertionSortImpl20190814.insertionSort(input);
		System.out.println("after: " + input.toString());
	}
	
	private void insertionSort(int[] input) {
		int firstSortedIndex = 0;
		for(int unSortedIndex = firstSortedIndex+1; unSortedIndex < input.length; unSortedIndex++) {
			int elementToBeinserted = input[unSortedIndex];
			for(int sortedIndex = unSortedIndex-1; sortedIndex >=0 ; sortedIndex--) {
				if(elementToBeinserted <= input[sortedIndex]) {
					input[sortedIndex+1] = input[sortedIndex];
					input[sortedIndex] = elementToBeinserted;
				}
			}
		}
		System.out.println("after: " + input.toString());
	}

}
