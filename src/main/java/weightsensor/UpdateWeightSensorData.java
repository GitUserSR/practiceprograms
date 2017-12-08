package weightsensor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UpdateWeightSensorData {

	public static void main(String[] args) throws IOException {
		FileReader fileReader = new FileReader(new File(".").getCanonicalPath()+"/src/main/java/weightsensor/Singletact_exp_scrub.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = null;
		while((line = bufferedReader.readLine()) != null) {
			if(line.startsWith("frameindex")) {
				String []lineTokens = line.split("\\s");
				System.out.println("");
			}
		}
		System.out.println("test");
	}

}
