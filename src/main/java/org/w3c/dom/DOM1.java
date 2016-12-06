package org.w3c.dom;

import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DOM1 {

	public static void main(String[] args) {
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		Document document = null;
		try{
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(new FileInputStream(System.getProperty("user.dir")+"/src/main/java/org/w3c/dom/dom1.xml"));
			NodeList nodeList = document.getChildNodes();
			for(int i=0; i<nodeList.getLength(); i++){
				Node node = nodeList.item(i);
				System.out.println(node.getTextContent());
				if(node instanceof Element){
					Element element = (Element)node;
					System.out.println(element.getTextContent());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

}
