package interviewQuestions;

public class ReverseAString {

	public static void main(String[] args) {
		ReverseAString reverseAString = new ReverseAString();
		int i[] = {1,2,3,4,5};  System.out.println(i.length); 
		int j[] = new int[10]; System.out.println(j.length); 
		System.out.println(reverseAString.reverseString("swathi"));
	}
	private String reverseString(String input) {
		String reverseStr = new String();
		StringBuffer temp = new StringBuffer();
		for(int i=input.length()-1; i>=0; i--) {
			temp.append(input.charAt(i));
		}
		return temp.toString();
		
		
	}
}
