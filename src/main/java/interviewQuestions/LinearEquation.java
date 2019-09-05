package interviewQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class LinearEquation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter equation comma seperated coefficients: ");
		String coefficients = scanner.nextLine();
		System.out.print("Enter equation comma seperated values: ");
		String values = scanner.nextLine();
		while (values != null) {
			computeLinearEquation(coefficients, values);
			values = scanner.nextLine();
		}
		scanner.close();
	}

	private static void computeLinearEquation(String coefficients, String values) {
		float value = 0;
		String[] equationCoefficents = coefficients.replace(" ", "").split(",");
		String[] equationVariables = values.replace(" ", "").split(",");
		//Float[] equationCoefficents = Arrays.stream(equationCoefficentStr).map(Float::valueOf).toArray(Float[]::new);
		//Float[] equationVariables = Arrays.stream(variables).map(Float::valueOf).toArray(Float[]::new);
		if(equationVariables.length != (equationCoefficents.length-1)) {
			System.out.println("Incorrect equation values");
		}
		value = value + Float.parseFloat(equationCoefficents[0]);
		for (int i = 0; i < equationVariables.length; i++) {
			value = value +  Float.parseFloat(equationCoefficents[i + 1]) *  Float.parseFloat(equationVariables[i]);
		}
		if(value > 0) {
			System.out.println("suspect fraud");
		}else if(value <= 0) {
			System.out.println("not fraud");
		}
	}
	
	private void compute() {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int totalScore = 0;
        for(int t = 0; t < n; t++) {
            String[] pointsStr = sc.nextLine().replace(" ", "").split(",");
            if(Integer.parseInt(pointsStr[0]) == 10 ) {
            	totalScore = totalScore + 10;
            	continue;
            }else {
            	totalScore = totalScore + Integer.parseInt(pointsStr[0]) + Integer.parseInt(pointsStr[1]);
            }
        }
	}
    private static void strike() {
    	
    }
    
    private void spare() {
    	
    }
}
