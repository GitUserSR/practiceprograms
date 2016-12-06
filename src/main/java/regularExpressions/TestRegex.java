package regularExpressions;

import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
	
	private static final String paramKey = "value(key)";

	public static void main(String[] args) {
		
		/*
		Pattern pattern = Pattern.compile("(\\.idms.core\\.)*Test*");
		Matcher matcher = pattern.matcher("com.apple.idms.core.configuration.ConfigurationTest.");
		if(matcher.find()){
			System.out.println("true");
		}
		
		Pattern p2 = Pattern.compile("^[a-zA-Z]+([0-9]+).*");
		Matcher m2 = p2.matcher("Testing123Testing");

		if (m2.find()) {
			System.out.println(m2.group(0));
		    System.out.println(m2.group(1));
		}
		
		String  s = "|2~21381030213jafjs231|adfafafasdfas";
		Matcher m = Pattern.compile("\\|\\d~([^|]+)\\|").matcher(s);
		if ( m.find() ) {
		  System.out.println(m.group(1));
		}
		
		String s4="serviceProviderCode=BPTDEV|ID1=DUB14|ID2=00000|ID3=000NU|ID4=000NU";
		Pattern p4= Pattern.compile("ID[1-3]=([^|]+)");
		Matcher m4 = p4.matcher(s4);
		String id = null;
		while( m4.find()) {
			id = (id==null) ? m4.group(1) : (id+"-"+m4.group(1));			  
		}
		System.out.println(id);
		
		String s5="sourceNumber=888|refAddressId=924597894";
		Pattern p5 = Pattern.compile("([^=^&]+)="); // ( : begin capturing group, ([^=^|]+ : match one ore more 'non =' or "non |" characters  , ) : end matching group, = : match string with = at the end
		System.out.println(s5.replaceAll("\\|", "&"));
		Matcher m5 = p5.matcher(s5.replaceAll("\\|", "&"));
		String parameters = s5;
		while( m5.find()) {
			System.out.println(m5.group(1));
		}
		
		String s6 = "https://www.google.comtestKey=testVal";
		//String s6 = "https://www.google.com?testKey=";
		Pattern isEndingwithKeyValuePattern = Pattern.compile("(.*[=]\\w+$)");
		Matcher isEndingwithKeyValueMatcher = isEndingwithKeyValuePattern.matcher(s6);
		
		System.out.println(isEndingwithKeyValuePattern.equals(s6));
		if(s6.matches(".*[=]\\w+$")) {
			System.out.println("ends with this pattern");
		}
		
		if(!s6.contains("?")){
			System.out.println("true");
		}
		
		
		String encodedStr = "/portlets/commons/console/navigationRoot.jsp?targetURL=%2Fportlets%2Fcommons%2Fprofessional%2FrefProfessional.jsp&navURL=%2Fportlets%2Fprofessional%2Fref%2FrefProfessionalList.do%3Frecentview%3Dtrue%26accelasubmitbuttonname%3Dsubmit%26module%3DBuilding%26value%28serviceProviderCode%29%3DBPTDEV%26licSeqNbr%3D13";
		System.out.println(URLDecoder.decode(encodedStr));
		
		
		String entityId = "serviceProviderCode=BPTDEV|g1AssetSequenceNumber=4";
		String queryString = entityId.replaceAll("\\|", "&");
		Pattern paramKeyPattern = Pattern.compile("([^=^&]+)=");
		Matcher keyMatcher = paramKeyPattern.matcher(queryString);
		while(keyMatcher.find()) {
			queryString = queryString.replace(keyMatcher.group(1), paramKey.replace("key", keyMatcher.group(1)));
		}
		System.out.println(queryString);
		*/
		
		String serverNames = "av.cfmx, av.biz, av.reporting,av.web";
		serverNames = serverNames.replace("and", ",");
		Pattern serverNamePattern1 = Pattern.compile("([^,]+)");

		Matcher serverNameMatcher1 = serverNamePattern1.matcher(serverNames);
		while(serverNameMatcher1.find()) {
			System.out.println(serverNameMatcher1.group(1).trim());
		}
	}

}
