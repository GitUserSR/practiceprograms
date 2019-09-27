package leetcode.medium;

import java.util.Set;

public class MinDominoRotations {
	int[] top = {2,1,2,4,2,2};
	int[] bottom = {5,2,6,2,3,2};
	//Set<Integer> rotations = new SortedSet<Integer>();

	public static void main(String[] args) {
		
	}
	
	public void getMinDominoRotations() {
		
	}
	
	public void makeDominoRotation() {
		for(int i =0; i< top.length; i++) {
			int temp = top[i];
			top[i] = bottom[i];
			bottom[i] = temp;
		}
		checkDominosEqual(top);
		checkDominosEqual(bottom);
	}
	
	public boolean checkDominosEqual(int[] domino) {
		boolean isEqual = false;
		for(int i = 0; i< top.length; i++) {
			int firstValue = domino[0];
			if(firstValue != domino[i+1]) {
				return isEqual;
			}else {
				isEqual = true;
				//rotations ++;
			}
		}
		return isEqual;
	}
}
