package javax;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParserFactory;

public class SAXParser {

	public static void main(String[] args) {

	}
	
	private static SAXParser getSAXParser(){
		try{
			SAXParserFactory spf = SAXParserFactory.newInstance();
			
			//prevents xml entity expansion injection attacks
			spf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true); 
			
			//disable DTD validation starts
			spf.setFeature("http://apache.org/xml/features/validation/schema", false); 
			spf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			//disable DTD validation ends
			
            spf.setFeature("http://xml.org/sax/features/external-general-entities", false);
            spf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
		}catch(Exception e){
			
		}
		return new SAXParser();
	}

}
