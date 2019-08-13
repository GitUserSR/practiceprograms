package leetcode;

import java.util.Arrays;

public class TwoSum {
	
	public static void main(String args[]) {
		int[] input = {2, 7, 11, 15, 6, 3};
		int target = 9;
		try {
			System.out.println("indices: "+ Arrays.toString(twoSum(input, target)));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public static int[] twoSum(int[] nums, int target) throws IllegalAccessException {
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					return new int[] {i, j};
				}
			}
		}
		throw new IllegalAccessException("No two sum solution");
	}

}
