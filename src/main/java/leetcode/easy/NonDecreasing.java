package leetcode.easy;

public class NonDecreasing {
    public static void main(String[] args) {
       // int[] nums = {4,2,3};
       // int[] nums = {2,3,3,2,4};
        int[] nums = {-1, 4, 2, 3};
        new NonDecreasing().checkPossibility(nums);
    }

    public boolean checkPossibility(int[] nums) {
        boolean isPossible = false;
        if(nums.length < 2) return true;
        int i = isDecreasing(nums);
        if(i==0){
            nums[i] = nums[i+1];
            i = isDecreasing(nums);
            if(i<0){isPossible = true;}
        }else if(i > 0){
            if(nums[i+1] < nums[i-1]){
                nums[i+1] = nums[i];
            }else{
                nums[i] = nums[i+1];
            }
            i = isDecreasing(nums);
            if(i<0){isPossible = true;}
        }else{
            isPossible = true;
        }
        return isPossible;
    }

    public int isDecreasing(int[] nums){
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
              return i;
            }
        }
        return -1;
    }
}
