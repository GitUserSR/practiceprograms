package dataStructuresAndAlgorithms.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int[] input = {8,2,4,9,3,6};
		int iterations = 0;
		for(int i=0; i<input.length-1; i++){
			iterations++;
			for(int j=i+1; j>0; j--){
				iterations++;
				if(input[j] < input[j-1]){
					int temp = input[j];
					input[j] = input[j-1];
					input[j-1] = temp;
				}
			}			
		}

		System.out.println(iterations);
		
		InsertionSort(input);
	}
	
	
	public static void InsertionSort( int [ ] num)
	{
	     int j;                     // the number of items sorted so far
	     int key;                // the item to be inserted
	     int i;  
	     int iterations =0 ;
	     for (j = 1; j < num.length; j++)    // Start with 1 (not 0)
	    {
	    	 iterations++;
	           key = num[ j ];
	           for(i = j - 1; (i >= 0) && (num[ i ] < key); i--)   // Smaller values are moving up
	          {
	        	   iterations++;
	                 num[ i+1 ] = num[ i ];
	          }
	         num[ i+1 ] = key;    // Put the key in its proper location
	     }
	     
	     System.out.println(iterations);
	}

}
