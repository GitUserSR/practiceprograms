package dataStructuresAndAlgorithms.sorting;

import java.util.Arrays;

public class InsertionSortIITD {

	public static void main(String[] args) {
		int input[] = {3,4,6,8,9,7,2,5,1};
		
		int ascInput[] = insertionSortAscending(input);
		int descInput[] = insertionSortDescending(input);
		System.out.println(input);
	}
	
	private static int[] insertionSortAscending(int input[]){
		int[] output = new int[input.length];
		output = Arrays.copyOf(input, input.length);
		
		int length = output.length;
		for(int j= 1; j < length ; j++) {
			int key = output[j];
			int i = j-1;
			while (i>=0 && output[i] > key) {
				output[i+1] = output[i];
				i--;
			}
			output[i+1] = key;	
		}
		return output;		
	}
	
	private static int[] insertionSortDescending(int input[]) {
		int[] output = Arrays.copyOf(input, input.length);
		
		for(int j=1; j < output.length; j++) {
			int key = output[j];
			
			for(int i =j-1; i>=0 && output[i] < key; i--) {
				output[i+1] = output[i];
				output[i] = key;
			}
			
		}
		return output;
	}

}
