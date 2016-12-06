package brainteasers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sudoku {
	
	public static void main(String args[]){
		Sudoku sudoku = new Sudoku();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter n for a matrix nXn:");
		int matrixSize = scanner.nextInt();
		
		//getMatrixElements
		List<Integer> matrixElements = sudoku.getMatrixElements(matrixSize);
		
		//calculate the min and max number of sum of rows and columns
		
		//assume that possible number is only 15
		
		
		
		//print matrix
		
	}
	
	
	
	private List<Integer> getMatrixElements(int matrixSize){
		int length = matrixSize*matrixSize;
		List<Integer> elements = new ArrayList<Integer>();
		for(int i=1; i<=length; i++){
			elements.add(i);
		}
		return elements;
	}
}
