package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class RemoveDeplicatesFromSortedArray {
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		System.out.println(new RemoveDeplicatesFromSortedArray().removeDuplicatesWithExtraMemory(nums));
	}
	
	 public int removeDuplicatesWithExtraMemory(int[] nums) {
		int length = nums.length;
		Map<Integer, Integer> numberCount = new HashMap<>();
	    for(int i=0; i< length; i++) {
	    	Integer key = nums[i];
	    	Integer count = (numberCount.get(key) == null) ? 0 : numberCount.get(key);
	    	if(count > 2) {
	    			for(int j=i; j < length; j++) {
	    				nums[i] = nums[i+1]; 
	    			}
	    	}
	    	numberCount.put(key,count++);
	    }
	    return nums.length;
	}
}
