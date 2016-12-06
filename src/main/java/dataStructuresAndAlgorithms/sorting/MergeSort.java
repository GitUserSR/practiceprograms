package dataStructuresAndAlgorithms.sorting;

public class MergeSort {

	public static void main(String[] args) {
		int[] input_odd = {7,5,8,1,3,5,6};
		int[] input_even = {7,5,8,1,3,5};
		new MergeSort().doMergeSoet(input_odd);
		new MergeSort().doMergeSoet(input_even);
	}
	
	private void doMergeSoet(int[] input){
		//find if he list is even or odd
		System.out.println(input.length);
	}

}
