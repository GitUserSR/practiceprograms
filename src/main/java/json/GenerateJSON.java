package json;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class GenerateJSON {
	public static void main(String args[]){
		
		ConsolePagesPortlets consolePagesPortlet = new ConsolePagesPortlets();
		consolePagesPortlet.setId("V360 Administration Portlet");
		consolePagesPortlet.setTitle("Administration:en$$ç®¡ç�†:zh$$Ø§Ù„Ø¥Ø¯Ø§Ø±Ø©:ar$$Ø§Ù„Ø¥Ø¯Ø§Ø±Ø©(Administration):de");
		consolePagesPortlet.setUrl("/portlets/framework/includes/error/blank.jsp");
		consolePagesPortlet.setWidth("100%");
		consolePagesPortlet.setHeight("600px");
		consolePagesPortlet.setScrolling("no");
		consolePagesPortlet.setOnload("");
		
		List<ConsolePagesPortlets> consolePagesPortlets = new ArrayList<ConsolePagesPortlets>();
		consolePagesPortlets.add(consolePagesPortlet);
		consolePagesPortlets.add(consolePagesPortlet);

		
		ConsolePages consolePages = new ConsolePages();
		consolePages.setId("Home");
		consolePages.setTitle("Home Title-As of now this info is not available in V360. Is it part of new UI ?");
		consolePages.setDescription("some description for the Building Permits page here-As of now this info is not available in V360. Is it part of new UI ?");
		consolePages.setLayout("one-column");
		consolePages.setPortlets(consolePagesPortlets);
		
		UserConsole userConsole = new UserConsole();
		userConsole.setId("BPTDEV.22.CONSOLE");
		userConsole.setPages(consolePages);
		
		//Java Object to JSON
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = null;
		try {
			json = ow.writeValueAsString(userConsole);
			System.out.println(json);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//JSON to Java Object
		ObjectMapper mapper = new ObjectMapper();
		UserConsole jsontoJavaUserConsole;
		try {
			jsontoJavaUserConsole = mapper.readValue(json, UserConsole.class);
			System.out.println(jsontoJavaUserConsole.getId());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}