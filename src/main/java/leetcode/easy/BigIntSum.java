package leetcode.easy;

import java.math.BigDecimal;
import java.util.Scanner;

public class BigIntSum {
    public static void main(String[] args) {
        //System.out.println(Math.pow(2,32));
        //System.out.println("Integer.parseInt(\"1231456416541214651356151564651954156\") = " + Integer.parseInt("1231456416541214651356151564651954156"));

        Scanner scanner = new Scanner(System.in);
        int inputSize = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Array input");
        String inputStr= scanner.nextLine();
       // inputStr = "1000000001 1000000002 1000000003 1000000004 1000000005";
        String[]  inputStrArr= inputStr.split(" ");




        int[] inputIntArr = new int[inputSize];
        long sum = 0;

        for(int i=0; i<inputSize; i++){
            try{
                inputIntArr[i] = Integer.parseInt(inputStrArr[i]);
                //double j = Double.parseDouble(inputStrArr[i]);
                //double k = Math.pow(2, 31);
               //System.out.println(j-k);
                sum += inputIntArr[i];
            }catch(Exception e){
                System.out.println("Invalid Number at position i:" + i);
            }//int hold 2b 1000000001
        }
        System.out.println("sum = " + sum);
    }


}
