package dataStructuresAndAlgorithms.sorting;

import java.util.Arrays;
/**
 * Time complexity O(n2), Space Complexity O(n)
 * @author srapolu
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int input[] = {4, 8, 0, 3, 9, 1, 6, 5, 7, 2};
		bubbleSort(input);
	}
	
	private static void bubbleSort(int input[]) {
		System.out.println("Input:" +Arrays.toString(input));
		for(int i=0; i<input.length-1; i++) {
			for(int j=0; j<input.length-1; j++) {
				if(input[j] > input[j+1]) {
					swap(input, j, j+1);
				}
			}
			System.out.println("At "+i +" iteration: " +Arrays.toString(input));
		}
		System.out.println("Output:" +Arrays.toString(input));
	}
	
	private static void swap(int input[], int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	
	private static void bubbleSortOptimized(int[] input) {
		boolean isSorted = false;
		
	}
	
}
