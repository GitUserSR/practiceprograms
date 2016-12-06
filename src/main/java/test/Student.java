package test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class Student {
	
	int totalStudents;
	int[] studentIds;
	String[] studentNames;
	double[] studentScores = {55,98,88, 10, 10, 98, 100, 14, 14, 100};
	double averageScore;
	
	public static void main(String[] args) {
		Student student = new Student();
		student.readStudentData();
		student.calculateAverageStudentScore();		
		
		// sort changes the order scores are inputed. Using the same variable results in loosing order ids, names inputed
		double tempScores[] = Arrays.copyOf(student.studentScores, student.totalStudents);
		Arrays.sort(tempScores);
		
		student.highestScores(tempScores);
		student.lowestScores(tempScores);
		student.aboveAverageScores();
	}
	
	private void readStudentData(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of students: ");
		totalStudents = scanner.nextInt();
		
		//Initialize student data 
		studentIds = new int[totalStudents];
		studentNames = new String[totalStudents];
		studentScores = new double[totalStudents];
		
		//read user input
		for (int i=0; i<totalStudents; i++){
			System.out.print("Enter student ID, Name, and Score: ");
			studentIds[i] = scanner.nextInt();
			studentNames[i] = scanner.next();
			studentScores[i] = scanner.nextDouble();
		}
		scanner.close();
	}
	
	private void calculateAverageStudentScore(){
		averageScore = DoubleStream.of(studentScores).sum() / totalStudents;
		System.out.println("The average score is: "+ averageScore);
	}
	
	private void highestScores(double[] ascSortedStudentScores){
		double highestScore = ascSortedStudentScores[studentScores.length-1];
		System.out.print("Student with highest score: ");
		printStudentWithMatchingScore(highestScore);
		System.out.print("Student with second highest score: " );
		printStudentWithMatchingScore(secondHighestScore(ascSortedStudentScores));
	}
	
	private void lowestScores(double[] ascSortedStudentScores){
		double lowestScore = ascSortedStudentScores[0];
		System.out.print("Student with lowest score: ");
		printStudentWithMatchingScore(lowestScore);
		System.out.print("Student with second lowest score: " );
		printStudentWithMatchingScore(secondLowestScore(ascSortedStudentScores));
	}
	
	private void aboveAverageScores(){
		System.out.println("Students with the above average score are: ");
		for (int i=0; i<totalStudents; i++){
			if(studentScores[i] > averageScore){
				System.out.println("\t" + studentIds[i] + ", " + studentNames[i] + ", " + studentScores[i]);
			}
		}
	}
	
	private double secondHighestScore(double[] ascSortedStudentScores){
		int i = totalStudents-2;
		double higestScore = ascSortedStudentScores[totalStudents-1];
		while(higestScore == ascSortedStudentScores[i]){
			i--;		
		}	
		return ascSortedStudentScores[i];
	}
	
	private double secondLowestScore(double[] ascSortedStudentScores){
		int i = 1;
		double lowestScore = ascSortedStudentScores[0];
		while(lowestScore == ascSortedStudentScores[i]){
			i++;		
		}	
		return ascSortedStudentScores[i];
	}
	
	private void printStudentWithMatchingScore(double studentScore){
		for (int i=0; i<totalStudents; i++){
			if(studentScores[i] == studentScore){
				System.out.print(studentIds[i] + ", " + studentNames[i] + ", " + studentScores[i] + "\t");
			}
		}
		System.out.print("\n");
	}
} 
