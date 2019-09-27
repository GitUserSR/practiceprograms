package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import test.Solution;

public class FindDisappearedNumbers {

	public static void main(String[] args) {
		FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();
		findDisappearedNumbers.findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 });
		findDisappearedNumbers.findDisappearedNumbers(new int[] { 1, 2 });
		
	}

	public List<Integer> findDisappearedNumbers(int[] nums) {
		System.out.println(nums.length + "," + nums[nums.length - 1]);

		List<Integer> disappeareNumbers = new ArrayList<Integer>();
		int[] inPlaceNums = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == i + 1 || nums[i] != i + 1) {
				inPlaceNums[nums[i] - 1] = nums[i];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (inPlaceNums[i] == 0) {
				disappeareNumbers.add(i + 1);
			}
		}
		System.out.println(disappeareNumbers.toString());
		return disappeareNumbers;

	}
	

}
