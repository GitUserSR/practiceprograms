package interviewQuestions;

import java.util.Scanner;
import java.util.Arrays;

public class Bowling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Bowling().compute();
	}
	
	private static void compute() {
		
		System.out.println("Enter number of frames");
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int totalScore = 0;
        
        //int[][] frameValues = new int[n+1][2];
        int[] frameScore = new int[n];
      
        /*for(int t = 0; t < n; t++) {
            String[] frameValue = sc.nextLine().split(",");
            frameValues[t][0] = Integer.parseInt(frameValue[0]);
            frameValues[t][1] = Integer.parseInt(frameValue[1]);
        }*/
        int[][] frameValues = {{5,5},{2,8},{4,5}};
        for (int i = 0; i < n; i++) {
	        if(frameValues[i][0] != 10 && (frameValues[i][0] + frameValues[i][1] != 10) ) {
	        	frameScore[i] = frameValues[i][0] + frameValues[i][1];
	        }else if((frameValues[i][0] != 10 && frameValues[i][0] + frameValues[i][1] == 10 && i != n-1)) {
	        	frameScore[i] = frameValues[i][0] + frameValues[i][1] + frameValues[i+1][0];
	        }else if((frameValues[i][0] != 10 && frameValues[i][0] + frameValues[i][1] == 10 && i == n-1)) {
	        	frameScore[i] = frameValues[i][0] + frameValues[i][1] + frameValues[i+1][0];
	        	break;
	        }else if (frameValues[i][0] == 10 && i != n-1) {
	        	frameScore[i] = frameValues[i][0] + frameValues[i+1][0] + frameValues[i+1][1];
	        }else if (frameValues[i][0] == 10 && i == n-1) {
	        	frameScore[i] = frameValues[i][0] + frameValues[i+1][0] + frameValues[i+1][1];
	        	break;
	        }
        }
        for (int i = 0; i < n; i++) {
        	System.out.println("FrameScore "+i+" is "+frameScore[i]);
        	totalScore = totalScore + frameScore[i];
        }
        System.out.println("totalScore is " + totalScore);
	}	
}
	        /*        		frameValues[0][0] == 10) {
        	frameScore[0] = frameValues[0][0] + frameValues[1][0]+frameValues[1]1];
        
            if(Integer.parseInt(pointsStr[0]) == 10 ) {
            	framesScore[0][0] = 10;
            	continue;
            }else {
            	totalScore = totalScore + Integer.parseInt(pointsStr[0]) + Integer.parseInt(pointsStr[1]);
            }
        }
	}

	private int spareSum() {
		
	}
	
	private int
	*/ 

