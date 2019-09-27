package leetcode.medium;

public class StonesRemoved {

	public static void main(String[] args) {
		int[][] input =  {{0,0}, {1, 1},{2,2}};
		for(int i=0; i<input.length; i++) {
			for(int j=0; j <input[i].length; j++) {
				System.out.println(input[i][j]);
			}
		}
	}

}

/*
Solve usig graph


prepare a adjucancy list
2

sol-2: nodes - islands 

sol-3: Union Find Algorithm:
	
	dictionary for each stone. Start of with each stone as its own parent
	
*/