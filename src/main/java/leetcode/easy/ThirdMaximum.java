package leetcode.easy;

public class ThirdMaximum {
    public static void main(String[] args) {
       /* System.out.println(new ThirdMaximum().thirdMax(new int[]{3, 2, 1}));
        System.out.println(new ThirdMaximum().thirdMax(new int[]{1,2}));
        System.out.println(new ThirdMaximum().thirdMax(new int[]{2, 2, 3, 1}));*/
        System.out.println(new ThirdMaximum().thirdMax(new int[]{5,2,2}));
    }
    public int thirdMax(int[] nums) {
        int m1, m2, m3 ;
        m1 = nums[0];m2=Integer.MIN_VALUE; m3=Integer.MIN_VALUE;

        if(nums.length == 1){
           return nums[0];
        }
        if(nums.length == 2){
            if(nums[0] > nums[1]) {
                m1 = nums[0];
                m2 = nums[1];
                m3 = nums[1];
            }else{
                m1 = nums[1];
                m2 = nums[0];
                m3 = nums[1];
            }
        }

        for(int i=1; i<nums.length; i++){
            if(nums[i] > m1){
                m3 = m2;
                m2 = m1;
                m1 = nums[i];
            }else if(nums[i]!=m1 && nums[i] > m2){
                m3 = m2;
                m2 = nums[i];
            }else if(nums[i]!=m1 && nums[i]!=m2 && nums[i] > m3){
                m3 = nums[i];
            }
        }
        /*if(m3 == Integer.MIN_VALUE){
            m3 = m1;
        }*/
        return m3;
    }
}
