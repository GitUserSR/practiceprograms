package leetcode.medium;

public class FindPeak {

	public static void main(String[] args) {
		FindPeak findPeak = new FindPeak();
		System.out.println(findPeak.findPeakElement(new int[] {1,2,3,1}));
		System.out.println(findPeak.findPeakElement(new int[] {1}));
		System.out.println(findPeak.findPeakElement(new int[] {-2147483648}));
		System.out.println(findPeak.findPeakElement(new int[] {1,2}));
		System.out.println(findPeak.findPeakElement(new int[] {1,2,3}));
		System.out.println(findPeak.findPeakElement(new int[] {1,2,1,3,5,6,4}));
	}

	 public int findPeakElement(int[] nums) {
		for(int i=0; i<nums.length-1; i++) {
			if(nums[i] > nums[i+1]) {
				return i;
			}
		}
		return nums.length-1;
	 }

}
