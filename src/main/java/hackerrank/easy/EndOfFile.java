package hackerrank.easy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EndOfFile {

	public static void main(String[] args) {
		EndOfFile endOfFile = new EndOfFile();
		try {
			endOfFile.readInput();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void readInput() throws FileNotFoundException {
		/*Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		*/
		File file = new File("C:\\Users\\srapolu\\Google Drive\\Swathi\\Workspace\\PracticePrograms\\src\\main\\java\\hackerrank\\easy\\eof.txt");
		Scanner fileScanner = new Scanner(file);
		int lineCount = 1;
		while(fileScanner.hasNext()) {
			System.out.println(lineCount + " " + fileScanner.next());
			lineCount++;
		}
	}

}
