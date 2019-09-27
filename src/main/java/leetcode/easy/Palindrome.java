package leetcode.easy;

import java.util.regex.Pattern;

public class Palindrome {
    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        new Palindrome().isPalindrome(input);
    }
    private boolean isPalindrome(String input){
        input = input.replaceAll(("[^A-Za-z0-9 ]"),"");
        boolean isPalindrome = false;

        Pattern whiteSpacePattern = Pattern.compile("\\s");
        input = input.replaceAll("\\s","");

        input = input.toLowerCase();
        int length = input.length();

        for (int i = 0; i < length / 2; i++) {
            char frontChar = input.charAt(i);
            char backChar = input.charAt(length - 1 - i);
            if (frontChar != backChar) {
                isPalindrome = false;
                break;
            } else {
                isPalindrome = true;
            }
        }
        System.out.println("Palindrome.main "+isPalindrome);
        return isPalindrome;
    }
}
