package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class GenerateXLSFromProperties {

	// Read from User
	private final String BASE_ENV_PATH = "/Users/srapolu/Documents/Work/AA-ENV";
	private final String AA_PROPERTIES_FILE_PATH = "/Users/srapolu/Documents/Work/Accela Automation 7.3 FP2 Properties Files.xls";
	private final String OUTPUT_FILE_NAME = "/Users/srapolu/Documents/Work/Accela Automation 8.0 Properties Files";
	
	
	enum AAServer {
		cfmx("av.cfmx"), web("av.web"), biz("av.biz")
		/*, arw("av.arw"), cfmxRailo("av.cfmx_railo"), indexer("av.indexer"), ads("av.ads"), adsCfmx("av.ads.cfmx"), junit("av.junit")*/ ;

		String serverName;

		AAServer(String serverName) {                                   
			this.serverName = serverName;
		}

		String serverName() {
			return serverName;
		}
	}

	enum AAFile {
		System("conf/av/system.properties"), ServerConfig("conf/av/ServerConfig.properties"), SecurityConfig("conf/av/SecurityConfig.properties"), log4j_aa(
				"conf/av/log4j-aa.properties"), log4j_magnum("conf/av/log4j-magnum.properties");

		String filePath;

		AAFile(String filePath) {
			this.filePath = filePath;
		}

		String filePth() {
			return filePath;
		}
	}
	
	public HashMap<String, String> readConfigurationFromDocumentation() throws IOException {
		HashMap<String, String> configsFromDocumentation = new HashMap<String, String>();

		FileInputStream fileInputStream = new FileInputStream(AA_PROPERTIES_FILE_PATH);

		HSSFWorkbook workBook = new HSSFWorkbook(fileInputStream);
		Iterator<Sheet> sheetIterator = workBook.sheetIterator();

		while (sheetIterator.hasNext()) {
			// get sheet
			Sheet sheet = sheetIterator.next();
			String sheetName = sheet.getSheetName();
			System.out.println("Reading..." + sheetName);

			// iterate over each row
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();
			rowIterator.next(); // skip rows with row headings
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				// Property Name belongs to index 1;//Server Type belongs to
				// index 6
				if (null == row.getCell(1)) {
					continue;
				}

				String serverNames = row.getCell(6).getStringCellValue().trim();
				String propertyName = row.getCell(1).getStringCellValue().trim();
				String propertyValue = (null == row.getCell(2)) ? "" : row.getCell(2).toString().trim();

				if (!propertyName.isEmpty() && !propertyName.startsWith("#") && serverNames.isEmpty()) {
					//System.out.println("server name value is empty " + propertyName); //Do Nothing
				} else if ("all".equalsIgnoreCase(serverNames)) {
					for (AAServer aaServer : AAServer.values()){
						String key = aaServer.serverName + ":" + sheetName + ":" + propertyName;
						configsFromDocumentation.put(key, propertyValue);
					}
				} else {
					serverNames = serverNames.replace("and", ",");
					Pattern commaSeperated = Pattern.compile("([^,]+)");
					Matcher commaMatcher = commaSeperated.matcher(serverNames);
					while (commaMatcher.find()) {
						if(commaMatcher.group(1).trim().equalsIgnoreCase("av.reporting")){
							continue;
						}
						String key = commaMatcher.group(1).trim() + ":" + sheetName + ":" + propertyName;
						configsFromDocumentation.put(key, propertyValue);
					}
				}

			}

			System.out.println("End Reading..." + sheetName);
		}

		return configsFromDocumentation;
	}
	
	public HashMap<String, String> readConfigurationFromEnv() throws IOException {
		
		HashMap<String, String> configsFromEnv = new HashMap<String, String>();

		for (AAFile aaFile : AAFile.values())  {

			for (AAServer aaServer : AAServer.values()){
				String absoluteFilePath = BASE_ENV_PATH + "/" + aaServer.serverName + "/" + aaFile.filePath;
				
				if(new File(absoluteFilePath).exists()){
					Properties properties = readPropertiesFile(absoluteFilePath);
					for(Object k : properties.keySet()){
						String key = aaServer.serverName + ":" + aaFile + ":" + (String)k;
						String value = (String)k + "," + properties.getProperty((String)k);
						configsFromEnv.put(key,  value);
					}
				}else{
					System.out.println(absoluteFilePath + " does not exists");
				}
			}
		}
		return configsFromEnv;
	}

	public static void main(String[] args) throws IOException {
		
		//Server-File-PropertyName : PropertyName
		HashMap<String, String> oldVersionConfigs = new HashMap<String, String>();
		HashMap<String, String> newVersionConfigs = new HashMap<String, String>();


		GenerateXLSFromProperties generateXLSFromProperties = new GenerateXLSFromProperties();
		
		newVersionConfigs = generateXLSFromProperties.readConfigurationFromEnv();
		
		oldVersionConfigs = generateXLSFromProperties.readConfigurationFromDocumentation();

		Iterator<Map.Entry<String,String>> iter = oldVersionConfigs.entrySet().iterator();
		while (iter.hasNext()) {
		    Map.Entry<String,String> entry = iter.next();
		    String key = entry.getKey();
		    if(newVersionConfigs.containsKey(key)){
				newVersionConfigs.remove(key);
				iter.remove();
			}
		}
		
		for(String key : oldVersionConfigs.keySet()){
			System.out.println(key+","+oldVersionConfigs.get(key));
		}
		System.out.println("End Old");
		for(String key : newVersionConfigs.keySet()){
			System.out.println(key+","+newVersionConfigs.get(key));
		}
		System.out.println("test");

		/*
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("System");

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_FILE_NAME);
			workbook.write(fileOutputStream);
			fileOutputStream.close();
			System.out.println("File has been generated");


		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}*/
	}

	public static void writeToXLSSheet() {

	}

	public Properties readPropertiesFile(String filePath) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(filePath);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		return properties;
	}
	
	 
	
	

}
